package sorting;
import java.util.*;
public class duplicate {
    public static void main(String[] args) {
        int arr[] = {1,2,2,3,4,4,4,5};
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i++){
            map.put(arr[i] , map.getOrDefault(arr[i] , 0 )+1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
