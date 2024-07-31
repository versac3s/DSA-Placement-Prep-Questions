import java.util.ArrayList;
import java.util.*;

public class Arraylist_ques {
    public static void swap(ArrayList<Integer> list, int index1, int index2){
        int temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }
    public static void main(String args[]) {
        // primitive data types like int, char can't be stored directly
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // print reverse of the array
        
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i) + " ");
        }
        System.out.println();

        // find maximum in arrayList in linear time

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            // if (max < list.get(i)) {
            //     max = list.get(i);
            // }
            max = Math.max(max, list.get(i));
        }
        System.out.println("Maximum element= " + max);

        //swap two numbers

        int index1 = 1, index2= 3;
        swap(list, index1, index2);
        System.err.println(list);

        //Sorting in arraylist (in-built)

        Collections.sort(list); //sorts list in ascending order
        System.out.println("List in ascending order= "+list);
        Collections.sort(list, Collections.reverseOrder()); //descending order where reverseOrder is a comparator.
        System.out.println("List in descending order= "+list);


    }
}
