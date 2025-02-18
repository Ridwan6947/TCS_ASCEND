package sorting;

public class reverseNumber {
    public static void main(String[] args) {
        int  n = 123;
        int temp = 0;
        while(n > 0){
            int digit = n % 10;
            temp = temp * 10 + digit;
            n = n / 10;
        }
        System.out.println(temp);
    }
}
