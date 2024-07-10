import java.util.*;
public class areaofCircle {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter radius of circle: ");
        float radius = sc.nextFloat();
        float area = 3.14f*radius*radius; // here we wrote f after 3.14 because it was being taken as double by compiler
        System.out.println(area);
        //TYPE CASTING = zabardasti ki type conversion
        // for ex. int marks = (int)(99.99f)
        int marks = (int)(99.99f);
        System.out.println(marks);
        //TYPE PROMOTION- In java if there is an expression with multiple data types,java promotes each byte, short or char into int only.
        // if one operand is long, float or double whole exp is promoted to float or long or double, depending on largest data type available
        // type promotion of float long double etc cant be done into int because it will lead to lossy conversion. but we can still force it by type casting.
        char a = 'a';
        char b = 'b';
        System.out.println((int)(b));
        System.out.println((int)(a));
        System.out.println((int)(b-a));
        byte L = 5;
        // L = L*2; //this gives error because here, because of *, the L in exp is type promoted into int. int of 10 does not lie the byte range. thus error
        L  = (byte)(L*2); // soln
        System.out.println(L);
        
        int $ = 24; //name of variables are called identifiers. 
        //Identifiers can start with any letter or _ or $.


    }
}
