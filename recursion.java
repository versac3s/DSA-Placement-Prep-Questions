import java.util.*;

public class recursion {
    public static void recurse(int x) {
        if (x == 1) {
            System.out.println(x);
            return;
        }
        recurse(x - 1); // increasing order
        System.out.println(x);
        // put recurse (x-1) here if you want to print in decreasing order.

    }

    // REMOVE DUPLICATES IN A STRING
    public static void duplicateremove(String str, int i, StringBuilder newString, boolean arr[]) {
        //base case 
        if (i == str.length()) {
            System.out.println("New String = " + newString);
            return;
        }
        char currChar = str.charAt(i);
        if (arr[currChar - 'a'] == true) { //currChar-'a' gives index in the array of 26 letters.
            //duplicate detected
            duplicateremove(str, i + 1, newString, arr);
        } else {
            arr[currChar - 'a'] = true;
            duplicateremove(str, i + 1, newString.append(currChar), arr);
        }
    }
//FRIEND PAIRIN PROBLEM
//GIVEN N FRIENDS, EACH ONE CAN REMAIN SINGLE OR CAN BE PAIRED UP WITH SOME OTHER FRIEND.
//EACH FRIEND CAN BE PAIRED ONLY ONCE. FIND TOTAL NUMBEROF WAYS IN WHICH FRIENDS CAN REMAIN SINGLE OR BE PAIRED.
    public static int pairing(int n){
        if(n==1||n==2){
            return  n;
        }
        // //choice = single
        // int friendspair1 = pairing(n-1);
        // //choice = pair
        // int friendspair2= pairing(n-2);
        // int pairWays= (n-1)* friendspair2;
        // //total ways
        // int total = friendspair1+pairWays;
        // return total;
        return pairing(n-1)+pairing(n-2)*(n-1); //can do in single line only
    }
    //BINARY STRING PROBLEM
    //PRINT ALL BINARY STRINGS OF SIZE N WITHOUT CONSECUTIVES ONE.
    public static void binarystr(int n, int lastPlace, String str){
        if(n==0){
            System.out.println(str);
            return;
        }
        if(lastPlace==0){
            binarystr(n-1, 0, str+"0");
            binarystr(n-1, 1, str+"1");
        }else{
            binarystr(n-1, 0, str+"0");
        }
    }
    public static void main(String asrgs[]) {
        // System.out.println("Enter the number: ");
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // recurse(n);
        String str = "appnnacollege";
        duplicateremove(str, 0, new StringBuilder(""), new boolean[26]);
        System.out.println(pairing(3));
        binarystr(3,0,"");
    }
}
