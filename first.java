import java.util.*;
public class first{
    public static void main(String args[]){//boilerplate code - the main() function in java.
        System.out.println("****"); 
        System.out.println("***");
        System.out.println("**");
        System.out.println("*"); 
        System.out.print("In java we have: Literals and Variables\n");
        System.out.print("Java's terms like main, a, b, names of class, \nnames of functions, print, println etc are called IDENTIFIERS\n");
        int a = 10;
        int b = 5;
        int area= a*b;
        System.out.println("Area = " + area);
        System.out.println("Java has two data types: Primitive and Non-Primitive");
        
        //PRIMITIVE DATA TYPES
        float d = 1; //4 bytes
        byte c = 8; //Only 256 numbers allowed and takes 1 byte to memory (range: -128 to 127)
        char C= 'a';//2 bytes 'a' to 'z', @, ;,. 'A' to 'Z'
        boolean var= true; //1 byte
        //int 4 bytes
        //long (big size int) 8 bytes
        //double (big size float) 8 bytes
        //short (to store number) 2 bytes
        System.out.println(d);
        System.out.println(c);
        System.out.println(C);
        System.out.println(var);

        //INPUT IN JAVA
        Scanner sc = new Scanner(System.in); // input class
        String input = sc.next(); //taking input
        System.out.println(input);
        // to print the entire line with spaces, we use nextLine()
        String input2 = sc.nextLine();
        System.out.println(input2);
        // to take input of integer we use nextInt()
        int input3 = sc.nextInt();
        System.out.println(input3);
        // for float we have nextFloat(), more we have nextByte(), nextDouble() and so on...
        

    }
}

