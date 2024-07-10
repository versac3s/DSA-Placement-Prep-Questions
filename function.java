//FUNCTIONS AND METHODS
//METHODS- FUNCTIONS WRITTEN IN A CLASS ARE THE METHODS OF THAT CLASS.
import java.util.*;
public class function {
    //access modifier, return type, name()
    public static void printHello(){
        System.out.println("Hello World");
    }
    public static void Sum(int num1, int num2){//Parameters in function definition = formal parameter
        int sum= num1+num2;
        System.out.println(sum);
    }
    public static void main(String args[]){
        printHello();
        System.out.print("Enter two integers= ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        Sum(a,b); // Arguments/Actual parameters= values passed during function calls.
        }
    
}
//We have call by value and Call by Reference
//Java always Calls by Value (Value of var in functions passed is a copy of the original variable)
