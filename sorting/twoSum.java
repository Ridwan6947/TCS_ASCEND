package sorting;
import java.util.*;
public class twoSum {
    public static void main(String[] args) {
        int arr[] = {7,3,2,6,1,9};
        int target = 12;
        int ans[] = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        // for(int i = 0 ; i < arr.length-1 ; i++){
        //     for(int j = i+1 ; j < arr.length ; j++){
        //         if(arr[i] + arr[j] == target){
        //             arr[0] = arr[i];
        //             arr[1] = arr[j];
        //             break;
        //         }
        //     }
        // }
        for(int i = 0 ; i < arr.length ; i++){
            if(map.containsKey(target-arr[i])){
                ans[0] = arr[i];
                ans[1] = target - arr[i];
            }else{
                map.put(arr[i] , i);
            }
        }
        System.out.println(ans[0] + " " + ans[1]);
    } 
}
