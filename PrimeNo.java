//to check if number is prime or not
import java.util.Scanner;
public class PrimeNo {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        double n = sc.nextInt();
        if (n == 2) {
            System.out.println("Prime number");
        } else {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    isPrime = false;
                }
            }
            if (isPrime == true) {
                System.out.println("Prime Number");
            } else {
                System.out.println("Not prime");
            }
        }
    }
}