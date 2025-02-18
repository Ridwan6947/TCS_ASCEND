package sorting;
import java.util.*;
public class reverseWord {
    public static void main(String[] args) {
        String str = "My Name Is Ridwan";
        char[] arr = str.toCharArray();
        int si = 0 , ei = str.length()-1;
        while(si <= ei){
            char temp = arr[si];
            arr[si] = arr[ei];
            arr[ei] = temp;
            si++;
            ei--;

        }
        System.out.println(new String(arr));
    }
}
