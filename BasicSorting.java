import java.util.Arrays;
import java.util.Collections;
public class BasicSorting {
    public static void print(int arr[]){
        for(int i =0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void print1(Integer arr[]){
        for(int i =0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void bubbleSort(int arr[]){
        for(int turn = 0; turn<arr.length-1; turn++){
            for(int j=0; j<arr.length-1-turn; j++){
                if(arr[j]> arr[j+1]){
                    //swap within the loop
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }

            }
        }
    }
    public static void selectionSort(int arr[]){
        for(int i=0; i<arr.length -1; i++){
            int min = i;
            for(int j =i+1; j<arr.length;j++){
                if(arr[min]>arr[j]){
                    min = j;
                }
            }
            //swap
            int temp = arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
        }
    }
    public static void insertionSort(int arr[]){
        for(int i = 1 ; i<arr.length-1; i++){
            int curr = arr[i];
            int prev = i-1;
            while(prev >=0 && arr[prev]>arr[curr]){
                arr[prev+1]= arr[prev];
                prev--;
            }
            arr[prev+1]= curr;
        }
    }
    public static void countingSort(int arr[]){
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            largest = Math.max(largest, arr[i]);
        }
        int count[]= new int[largest+1];
        //traverse on original array
        for(int  i =0; i<arr.length; i++){
            count[arr[i]]++;
        }
        //sorting by traversing on the count[] array
        int j =0;
        for(int i =0; i<count.length; i++){
            while(count[i]>0){
                arr[j]=i;
                j++;
                count[i]--;
            }
        }
    }
    public static void main(String[] args) {
        int arr[]={5,4,1,3,2};
        bubbleSort(arr);
        print(arr);
        selectionSort(arr);
        print(arr);
        insertionSort(arr);
        print(arr);
        //Using java inbuilt sort with time complexity = O(nlogn)
        Arrays.sort(arr);
        print(arr);
        Arrays.sort(arr, 0,3);
        print(arr);
        Integer arr1[] = {5,4,1,3,2};
        //we made new array because reverseOrder() works only on objects and not on primitive type var
        Arrays.sort(arr1, Collections.reverseOrder());
        print1(arr1);
        Arrays.sort(arr1, 1, 3, Collections.reverseOrder());
        print1(arr1);
        countingSort(arr);
        print(arr);


        
    }
    
}
