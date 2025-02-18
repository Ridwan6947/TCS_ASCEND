package sorting;

public class insertionSort {
    public static void main(String[] args) {
        int arr[] = {7,6,5,2,1,4,3};
        int n = arr.length;
        for(int i = 1 ; i < n ; i++){
            int curr = arr[i];
            int j = i-1;
            while(j >= 0 && curr < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = curr;
        }
        for(int i : arr){
            System.out.println(i);
        }
    }
}
