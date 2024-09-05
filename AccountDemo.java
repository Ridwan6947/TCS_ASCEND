public class AccountDemo {
    public static double deductInterest(enumDemo obj , double percentage){
        if(obj.accType.equals(AccountType.CURRENT)){
            double balance = obj.balance - obj.balance*percentage/100;
            obj.balance = balance;
        }

        return obj.balance;
    }

    public static void main(String[] args) {

        enumDemo obj = new enumDemo(1, 1000, 1, AccountType.CURRENT);
        double percentage = 5;
        double balance = deductInterest(obj, percentage);
        System.out.println("Balance after interest deduction: " + balance);
    }
}
