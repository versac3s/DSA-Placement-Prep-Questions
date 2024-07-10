public class Ouick_Sort {
    public static void printArr(int arr[]) {
        for (int i = 0; i <= arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }
    public static void quicksort(int arr[],int start, int end){
        if(start>=end){
            return;
        }
        int index= partition(arr,start,end);
        quicksort(arr,start,index-1);
        quicksort(arr,index+1, end);
    }
    public static int partition(int arr[],int start,int end){
        int pivot = arr[end];
        int i= start-1;
        for(int j=start; j<end; j++){
            if(arr[j]<=pivot){
                i++;
                int temp =arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        i++;
        int temp =pivot;
        arr[end]=arr[i];
        arr[i]=temp;
        return i;
    }
    public static void main(String args[]) {
        int arr[] = { 0, 9, 8, 7, 1, 2, 5, 7 };
        quicksort(arr, 0, arr.length - 1);
        printArr(arr);
    }
    
}
