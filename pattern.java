//making inverted patterns
public class pattern {
    public static void main(String args[]) {
        // for(int line= 1; line<=5; line++){
        // for(int star = 5; star>=line; star--){
        // System.out.print("*");
        // }
        // System.out.println("");
        char ch='A';
        int n = 4;
        for (int line = 1; line <= n; line++) {
            for (int number = 1; number <= line; number++) {
                System.out.print(ch+" ");
                ch++;
            }
            System.out.println();
        }
    }
}
