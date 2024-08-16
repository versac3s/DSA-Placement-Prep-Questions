import java.util.*;
//time complexity = O(nlogn)
public class HeapSort {
    public static void heapify(int arr[],int i, int size){
        int left = 2*i+1;
        int right=2*i+2;
        int maxIndex=i;
        if(left<size&& arr[left]>arr[maxIndex]){
            maxIndex = left;
        }
        if(right<size&& arr[right]>arr[maxIndex]){
            maxIndex = right;
        }
        if(maxIndex!=i){
            //swap
            int temp = arr[i];
            arr[i]=arr[maxIndex];
            arr[maxIndex]=temp;

            heapify(arr,maxIndex,size);
        }
    }
    public static void heapSort(int arr[]){
        //1. convert arr into maxHeap
        //for all leaf nodes we call heapify
        int n=arr.length;
        for(int i=n/2;i>=0;i--){
            heapify(arr, i,n); //time complexity = logn*n
        }

        //2. Push largest element to the end
        //ie we swap the element at index 0 with our last element
        for(int i=n-1; i>0; i--){
            //swap
            int temp = arr[0];
            arr[0]=arr[i];
            arr[i]=temp;

            heapify(arr,0,i);
        } 
    }
    public static void main(String[] args) {
        int arr[]={1,2,4,5,3};
        heapSort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]+" ");
        }
    }
    
}
