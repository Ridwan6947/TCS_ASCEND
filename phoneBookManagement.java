import java.util.*;

class Contact {
    private int contactID;
    private String name;
    private String contactType;
    private int numberOfContacts;
    private Set<Integer> phoneNumbers;

    // Constructor
    public Contact(int contactID, String name, String contactType, int numberOfContacts, Set<Integer> phoneNumbers) {
        this.contactID = contactID;
        this.name = name;
        this.contactType = contactType;
        this.numberOfContacts = numberOfContacts;
        this.phoneNumbers = phoneNumbers;
    }

    // Getters
    public int getContactID() { return contactID; }
    public String getName() { return name; }
    public String getContactType() { return contactType; }
    public int getNumberOfContacts() { return numberOfContacts; }
    public Set<Integer> getPhoneNumbers() { return phoneNumbers; }

    // Setters
    public void setContactID(int contactID) { this.contactID = contactID; }
    public void setName(String name) { this.name = name; }
    public void setContactType(String contactType) { this.contactType = contactType; }
    public void setNumberOfContacts(int numberOfContacts) { this.numberOfContacts = numberOfContacts; }
    public void setPhoneNumbers(Set<Integer> phoneNumbers) { this.phoneNumbers = phoneNumbers; }
}

class PhoneBook {
    private String categoryName;
    private int cNum;
    private List<Contact> contactList;

    // Constructor
    public PhoneBook(String categoryName, int cNum, List<Contact> contactList) {
        this.categoryName = categoryName;
        this.cNum = cNum;
        this.contactList = contactList;
    }

    // Getters
    public String getCategoryName() { return categoryName; }
    public int getCNum() { return cNum; }
    public List<Contact> getContactList() { return contactList; }

    // Setters
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public void setCNum(int cNum) { this.cNum = cNum; }
    public void setContactList(List<Contact> contactList) { this.contactList = contactList; }

    // Method to get contact details by name
    public String getContactByName(String name) {
        StringBuilder result = new StringBuilder();
        boolean found = false;

        for (Contact contact : contactList) {
            if (contact.getName().equals(name)) {
                result.append(contact.getContactID()).append(" ")
                      .append(contact.getName()).append(" ")
                      .append(contact.getContactType()).append("\n");

                for (Integer number : contact.getPhoneNumbers()) {
                    result.append(number).append("\n");
                }
                found = true;
            }
        }

        return found ? result.toString().trim() : "Not Found!";
    }

    // Method to get unique contacts in a category in alphabetical order
    public String contactsInCategory(String category) {
        if (!this.categoryName.equals(category)) {
            return "No such category found";
        }

        Set<String> uniqueNames = new TreeSet<>();
        for (Contact contact : contactList) {
            uniqueNames.add(contact.getName());
        }

        return uniqueNames.isEmpty() ? "No contacts Found!" : String.join("\n", uniqueNames);
    }
}

public class phoneBookManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // Number of contacts
        sc.nextLine(); 

        List<Contact> contacts = new ArrayList<>();
        Map<String, List<Contact>> categoryMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int contactID = sc.nextInt();
            sc.nextLine(); 
            String name = sc.nextLine();
            String contactType = sc.nextLine();
            int numOfContacts = sc.nextInt();
            sc.nextLine(); 

            Set<Integer> phoneNumbers = new HashSet<>();
            for (int j = 0; j < numOfContacts; j++) {
                phoneNumbers.add(sc.nextInt());
                sc.nextLine(); 
            }

            Contact contact = new Contact(contactID, name, contactType, numOfContacts, phoneNumbers);
            contacts.add(contact);

            categoryMap.putIfAbsent(contactType, new ArrayList<>());
            categoryMap.get(contactType).add(contact);
        }

        // Creating phone book entries for each category
        List<PhoneBook> phoneBooks = new ArrayList<>();
        for (Map.Entry<String, List<Contact>> entry : categoryMap.entrySet()) {
            phoneBooks.add(new PhoneBook(entry.getKey(), entry.getValue().size(), entry.getValue()));
        }

        // Running the queries
        String query1 = sc.nextLine();
        String query2 = sc.nextLine();

        // Finding the contact by name
        boolean found = false;
        for (PhoneBook phoneBook : phoneBooks) {
            String result = phoneBook.getContactByName(query1);
            if (!result.equals("Not Found!")) {
                System.out.println(result);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Not Found!");
        }

        // Finding contacts in category
        found = false;
        for (PhoneBook phoneBook : phoneBooks) {
            String result = phoneBook.contactsInCategory(query2);
            if (!result.equals("No such category found")) {
                System.out.println(result);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No such category found");
        }

        sc.close();
    }
}
