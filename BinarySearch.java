public class BinarySearch {
    public static int binarySearch(int num[], int key) {
        int start = 0, end = num.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            // comparisons
            if (num[mid] == key) {
                return mid;
            }
            if (num[mid] < key) { // right
                start = mid + 1;
            } else {// left
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int array[] = { 1, 2, 3, 4, 5, 10, 11, 12, 13 };
        int key = 10;
        int index = binarySearch(array, key);
        if (index == -1) {
            System.out.println("Element not found in array");

        } else {
            System.out.println("index of key= " + index);
        }
    }
}
//time complexity = O(log2(n))