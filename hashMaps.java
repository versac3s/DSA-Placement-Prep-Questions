import java.util.HashMap;
import java.util.*;

public class hashMaps {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        // Operations in HashMap
        // put(key, value) used to insert a value in hashmap. Time complexity = O(1)
        hm.put("India", 150);
        hm.put("USA", 80);
        hm.put("China", 200);
        hm.put("Antartica", 12);
        System.out.println(hm);

        // get(key) used to get key from hashmap. You cannot pass "value" in it. Time complexity= O(1)
        int population = hm.get("India");
        System.out.println(population);

        // containsKey(key) is used to check if a given key exists in hashmap and
        // returns boolean value. Time complexity = O(1)
        System.out.println(hm.containsKey("Indonesia"));

        // remove(key) is used to remove an entry from hashmap. Time complexity = O(1)
        hm.remove("China");
        System.out.println(hm);

        // check size of map
        System.out.println(hm.size());

        // to clear the data inside the map
        hm.clear();

        System.out.println(hm);

        // Iterating on HashMap using sets
        Set<String> keys = hm.keySet();

        // adding values into hashmap again
        hm.put("India", 150);
        hm.put("USA", 80);
        hm.put("China", 200);
        hm.put("Antartica", 12);
        
        // using foreach loop we print the key k along with its value.
        // we can also use entrySet() for the same.
        for (String k : keys) {
            System.out.println("key= " + k + " value= " + hm.get(k));
        }

    }

}
