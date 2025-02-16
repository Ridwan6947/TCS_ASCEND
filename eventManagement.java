import java.util.*;

public class eventManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Event[] arr = new Event[4];
        for(int i = 0 ; i < arr.length ; i++){
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            sc.nextLine();
            int e = sc.nextInt();
            sc.nextLine();
            arr[i] = new Event(a,b,c,d,e);
        }
        int att = sc.nextInt();
        String loc = sc.nextLine();
        int total = countOfEvent(arr , att);
        Event ans = getLowest(arr , loc);
        System.out.println("____________________________");
        System.out.println(total);
        System.out.println(ans.getId());
        System.out.println(ans.getLocation());
    }
    public static Event getLowest(Event[] arr , String target){
        Event ans = null;
        int price = Integer.MAX_VALUE;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] != null || arr[i].getLocation().equalsIgnoreCase(target) && arr[i].getFee() < price){
                price = arr[i].getFee();
                ans = arr[i];
            }
        }
        return ans;
    }
    public static int countOfEvent(Event[] arr , int target ){
        int ans = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i].getAttendee() == target){
                ans++;
            }
        }
        return ans;
    }
}
class Event{
    int id;
    String name;
    String location;
    int fee;
    int attendee;

    public Event(int id , String name , String location , int fee , int attendee){
        this.id = id;
        this.name = name;
        this.location = location;
        this.fee = fee;
        this.attendee = attendee;
    }
    public int getId() {
        return id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for location
    public String getLocation() {
        return location;
    }

    // Getter for fee
    public int getFee() {
        return fee;
    }

    // Getter for attendee
    public int getAttendee() {
        return attendee;
    }
}