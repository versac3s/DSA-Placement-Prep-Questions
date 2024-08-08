
//MERGE SORT: SORTING IN ASCENDING
//ARRAY KA MID NIKALO,


public class Merge_sort {
    public static void printArr(int arr[]) {
        for (int i = 0; i <= arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

    public static void mergeSort(int arr[], int start, int end) {
        if (start >= end) {
            return; // base
        }
        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }
    public static void merge(int arr[], int start, int mid, int end) {
        int temp[] = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }
        for (k = 0, i = start; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }
    public static void main(String args[]) {
        int arr[] = { 0, 9, 8, 7, 1, 2, 5, 7 };
        mergeSort(arr, 0, arr.length - 1);
        printArr(arr);
    }
}
//Time complexity  = nlogn




