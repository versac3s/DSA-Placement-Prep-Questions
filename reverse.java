//printing reverse of a number
//logic = when we divide a num by 10, we get the last digit as remainder. we print that remainder to get the reverse of the num.
public class reverse {
    public static void main(String args[]) {
        int rev = 0;
        for (int n = 10899; n > 0; n = n / 10) {
            int lastDigit = n % 10;
            rev = (rev * 10) + lastDigit;
        }
          System.out.println(rev);
        
    }

}
