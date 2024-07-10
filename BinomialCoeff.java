import java.util.*;
public class BinomialCoeff {
    public static int factorial(int n){
        int f=1;
        for(int i = 1; i<=n; i++){
            f = f*i;
        }
        return f;
    }
    public static int BinCoeff(int n, int r){
        int n_fact = factorial(n);
        int r_fact = factorial(r);
        int d_fact = factorial(n-r);
        int BinCoeff = n_fact/(r_fact*d_fact);
        return BinCoeff;
    }
    public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the integers n and r");
    int n = sc.nextInt();
    int r = sc.nextInt();
    System.out.println(BinCoeff(n,r));
    }

    
}
