import java.util.*;

public class reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 12345;
        // String str = String.valueOf(n);
        // StringBuilder sb = new StringBuilder(str);
        // sb.reverse();
        // int ans = Integer.parseInt(sb.toString());
        // System.out.println(ans);
        int ans = reverse(n);
        System.out.println(ans);
    }
    public static int reverse(int n){
        int ans = 0;
        while(n > 0){
            int digit = n % 10;
            ans = ans * 10 + digit;
            n = n / 10;
        }
        return ans;
    }
}
