package sorting;
import java.util.*;

public class reverseString1 {
    public static void main(String[] args) {
        String str = "My Name is Ridwan";
        String[] arr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length - 1; i >= 0 ; i--){
            sb.append(arr[i]);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
