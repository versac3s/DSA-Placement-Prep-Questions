import java.util.*;

public class factorialREC {
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        int fnmn1 = factorial(n - 1);
        int fn = n * fnmn1;
       return fn;

    }
    public static int sum(int n){
        int sum = 0;
        if(n==1){
            return 1;
        }
        int sn = sum(n-1);
        sum = sn+n;
        return sum;

    }
    public static int fibonacci(int n){
        if(n==0 || n==1){
            return n;
        }
        int fib1 = fibonacci(n-1);
        int fib2 = fibonacci(n-2);
        int fib = fib1+ fib2;
        return fib;
    }
    public static boolean sorted(int array[], int i){
        if(i==array.length-1){
            return true;
        }
        if(array[i]> array[i+1]){
            System.out.println("Array is not sorted.");
            return false;
        }
        
        return sorted(array,i+1);
    }//first occurence
    public static int firstOcc(int arr[], int i,int key){
        if(arr[i]==arr.length-1){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return firstOcc(arr,i+1,key);
    }
    public static int lastOcc(int arr[], int i,int key){
        if(i==arr.length){
            return -1;
        }
        int isFound = lastOcc(arr,i+1,key);
        if(isFound ==-1 && arr[i]==key){
            return i;
        }
        return isFound;
    }
    //calculate x raised to n
    public static int power(int x, int n){
        if(n==0){
            return 1;
        }
        int optimise = power(x, n/2); // storing it in variable and then calculating makes 
                                    //time complexity = O(logn)
        int halfpowsq = optimise*optimise; 
        if(n%2 != 0){
            halfpowsq = x* halfpowsq;
        }
        return halfpowsq;
    }

    public static void main(String args[]) {
        //System.out.println("Enter a number");
        //Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        //int array[]={1,2,3,4,5,3};
        //System.out.println(lastOcc(array,0,3));
        //sorted(array,0);
        //System.out.println(factorial(n));
        //System.out.println(sum(n));
        //System.out.println(fibonacci(n));
        System.out.println(power(2,10));
    }   
}
