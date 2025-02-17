package sorting;

public class sorting {
    public static void main(String[] args) {
        int arr []= {3,2,4,5,1,6};
        bubbleSort(arr);
        //selectionSort(arr);
        //insertionSort(arr);
        //mergeSort(arr);
    }
    public static void bubbleSort(int[] arr){
        for(int i = 0 ; i < arr.length-1 ; i++){
            for(int j = 0 ; j < arr.length-i-1 ; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for(int i : arr){
            System.out.print(i + " ");
        }
    }  
    public static void selectionSort(int[] arr){
        for(int i = 0 ; i < arr.length-1 ;i++){
            int smallest = i;
            for(int j = i + 1 ; j < arr.length ; j++){
                if(arr[j] < arr[smallest]){
                    smallest = j;
                }
            }
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
    public static void insertionSort(int[] arr){
        for(int i = 1 ; i < arr.length ; i++){
            int curr = arr[i];
            int j = i-1;
            while(j >= 0 && curr < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = curr;
        }
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
    public static void mergeSort(int[] arr){
        int n = arr.length;
        divide(arr,0,n-1);

        for(int i : arr){
            System.out.print(i + " ");
        }
    } 
    public static void divide(int arr[] , int si , int ei){
        if(si >= ei){
            return;
        }
        int mid = si + (ei - si) / 2;
        divide(arr , si , mid);
        divide(arr , mid+1 , ei);

        conquer(arr , si , mid , ei);
    }
    public static void conquer(int [] arr , int  si , int mid , int ei){
        int sorted[] = new int[ei-si+1];
        int idx1 = si;
        int idx2 = mid+1;
        int x = 0;
        while(idx1 <= mid && idx2 <= ei){
            if(arr[idx1] <= arr[idx2]){
                sorted[x++] = arr[idx1++];
            }else{
                sorted[x++] = arr[idx2++];
            }
        }
        while(idx1 <= mid){
            sorted[x++] = arr[idx1++];
        }
        while(idx2 <= ei){
            sorted[x++] = arr[idx2++];
        }
        for(int i = 0 , j = si ; i < sorted.length ; i++ , j++){
            arr[j] = sorted[i];
        }
    }
}

