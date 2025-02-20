import java.util.*;

public class Main{
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(3);
        list.add(9);
        list.add(3);
        list.add(2);
        list.add(7);
        list.set(6,10);
        
        Integer arr[] = new Integer[list.size()];
        arr = list.toArray(arr);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i++){
            map.put(arr[i] , map.getOrDefault(arr[i] , 0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                System.out.print(entry.getKey());
            }
        }
        // for(int i = 0 ; i < arr.length ; i++){
        //     System.out.print(arr[i] + " ");
        // }
        // Iterator it = list.iterator();
        // while(it.hasNext()){
        //     System.out.println(it.next());
        // }
        
    }
}