
import java.util.*;
import java.util.HashMap;
import java.util.TreeMap;

public class hashMapForms {
    public static void main(String[] args) {
        // LINKED HASHMAP- a hashmap where the insertion order is maintained
        // we are able to maintain the order because instead of a list, we use Doubly
        // Linked List. the rest of time complexity is same.
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 100);
        lhm.put("USA", 80);
        lhm.put("China", 200);
        lhm.put("Russia", 300);

        // output would be in the same order of insertion.
        System.out.println(lhm);

        // In a Tree Map, the keys are sorted.
        // Red Black Trees data structure used to make tree map.
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India", 100);
        tm.put("USA", 80);
        tm.put("China", 200);
        tm.put("Russia", 300);

        // output would be in the sorted order of insertion.
        System.out.println(tm);

    }

}
