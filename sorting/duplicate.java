package sorting;
import java.util.*;
public class duplicate {
    public static void main(String[] args) {
        int arr[] = {1,2,2,3,4,4,4,5};
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i++){
            map.put(arr[i] , map.getOrDefault(arr[i] , 0 )+1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            //System.out.println(entry.getKey() + " " + entry.getValue());
            if(entry.getValue() > 1){
                list.add(entry.getKey());
            }
        }
        Iterator it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
