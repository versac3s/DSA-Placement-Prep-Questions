//LINEAR SEARCH
import java.util.Scanner;
public class LinearSearch {
    public static int linearSearch(int array[], int key){
    for (int i = 0; i<array.length; i++){
        if (array[i]==key){
            return i;
        }
    }
    return -1;
    }
   public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int array[]= {1,2,3,4,5,6,7,8,9,10};
    System.out.println("Enter an integer= ");
    int key = sc.nextInt();
    int index= linearSearch(array,key);
    if (index==-1){
        System.out.println("Element not found.");
    }
    else{
        System.out.println("Element found at index= "+ index);
    }
   } 
}
//Time Complexity = O(n) ie proportional to loop
