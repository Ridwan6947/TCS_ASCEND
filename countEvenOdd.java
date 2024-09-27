import java.util.*;

public class countEvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 4536782;
        int ans[] = count(n);
        System.out.println("Number of even digits: " + ans[0]);
        System.out.println("Number of odd digits: " + ans[1]);
    }
    public static int[] count(int n){
        int ans[] = new int[2];
        while(n > 0){
            int digit = n % 10;
            if(digit % 2 == 0){
                ans[0]++;
            }else{
                ans[1]++;
            }
            n = n / 10;
        }
        return ans;
    }
}
