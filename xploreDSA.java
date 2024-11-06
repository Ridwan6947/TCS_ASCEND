public class xploreDSA {
    public static void main(String[] args){
        int n = 123456;
        int counter = 0;
        while(n > 0){
            int remainder = n % 10;
            if(remainder % 2 != 0){
                counter++;
            }
            n = n / 10;
        }
        if(counter >= 3){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
