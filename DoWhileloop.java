//print num entered by users until a multiple of 10 is added
import java.util.Scanner;
public class DoWhileloop {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        do{
            int n = sc.nextInt();
            if (n %10 == 0){
                break; //if you use continue; here then the code will skip 10 multiples but wont exit the loop.
            }
            System.out.println("Number entered= "+n);
        }while(true);
        System.out.println("I am out of the loop");
    }
    
}
