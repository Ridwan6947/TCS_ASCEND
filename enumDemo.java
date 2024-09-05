// Enum to define different types of bank accounts
enum AccountType{
    SAVINGS(1),      // Savings account type with value 1
    FIXED(2),        // Fixed deposit account type with value 2
    CURRENT(3);      // Current account type with value 3

    private int value;  // Private field to hold the account type value

    // Constructor to initialize the enum with a specific value
    AccountType(int v){
        value = v;
    }

    // Getter method to retrieve the value of the enum
    public int getValue(){
        return value;
    }
}

// Class representing an account demo
public class enumDemo{
    int accId;            // Account ID
    double balance;       // Account balance
    int customerId;       // Customer ID
    AccountType accType;  // Type of account (enum)

    // Constructor to initialize the enumDemo object with values
    public enumDemo(int accId, double balance, int customerId, AccountType accType){
        super();  // Calls the constructor of the parent class (Object)
        this.accId = accId;            // Sets the account ID
        this.balance = balance;        // Sets the account balance
        this.customerId = customerId;  // Sets the customer ID
        this.accType = accType;        // Sets the account type
    }
}
