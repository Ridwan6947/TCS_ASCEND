package sorting;
import java.util.*;
public class reverseString2 {
    public static void main(String[] args) {
        String str = "My Name Is Ridwan";
        Stack<String> st = new Stack<>();
        String[] arr = str.split(" ");
        for(int i = 0 ; i < arr.length ; i++){
            st.push(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        while(!st.empty()){
            sb.append(st.pop());
            sb.append(" ");
        }
        System.out.println(sb.toString());

    }
}
