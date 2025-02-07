import java.util.*;

public class Main{
    public static void main(String[] args){
        int arr[] = {5,4,3,2,1};
        TreeMap<Integer,Boolean> map = new TreeMap<>();
        for(int i : arr){
            map.put(i , true);
        }
        Iterator<Integer> it = map.keySet().iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}

import java.util.*;


public class Main{
    public static void main(String[] args){
        TreeMap<Integer , String> map = new TreeMap<>();
        map.put(1 , "Mango");
        map.put(3 , "Apple");
        map.put(6 , "Banana");
        map.put(2 , "peach");
        map.put(4 , "guava");
        map.put(5 , "ridwan");

        Iterator <String> it = map.values().iterator();  // when we want to print only the values and not the key
        while(it.hasNext()){
            System.out.println( it.next());
        }

        Iterator <Map.Entry<Integer,String>> it = map.entrySet().iterator(); // when we want to print both key and value in pair
        while(it.hasNext()){
            Map.Entry<Integer,String> entry = it.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}