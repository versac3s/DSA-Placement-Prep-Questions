import java.util.*;

public class ternaryop {
    public static void main(String args[]) {
        // variable = condition?statement1:statement2;
        // if condition is true, statement 1 is executed else statement 2 is executed.
        int large = 5 > 3 ? 5 : 3;
        String type = ((large % 2 == 0) ? "even" : "odd");
        System.out.println(type);
    }
}
