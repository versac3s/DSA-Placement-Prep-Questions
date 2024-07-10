import java.util.Scanner;
public class LargestNum {
    public static int largestNum(int array[]){
        int largest = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++){
            if(largest<array[i]){
                largest= array[i];
            }
        }
        return largest;
    }
    public static int smallestNum(int array[]){
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i<array.length; i++){
            if(smallest>array[i]){
                smallest = array[i];
            }
        }
        return smallest;
    }
    public static void main(String args[]){
        int numbers[]= {1,9,2,6,3,7,4,22};
         
        System.out.println("Largest value= "+ largestNum(numbers));
        System.out.println("Smallest value= "+ smallestNum(numbers));

    }
    
}
