import java.util.*;
public class hashSet_1 {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();

        //operations in hashSet
        
        //inserting element in hashSet. Time complexity = O(1)
        hs.add(3);
        hs.add(4);
        hs.add(5);
        hs.add(3); //duplicate entries are not added
        hs.add(6);
        hs.add(7);
        System.out.println(hs);

        //check is set contains a given key. Time complexity = O(1)
        if(hs.contains(3)){
            System.out.println("Element 3 is present");
        }else{
            System.out.println("Element is not present");
        }

        //removing an element. Time complexity = O(1) 
        hs.remove(3);
        System.out.println(hs);

        //size of set
        System.out.println("Size= "+hs.size());

        //Clear all elements in set T=O(1)
        hs.clear();

        //Check if set is empty. T=O(1)
        System.out.println(hs.isEmpty());

        //adding back elements
        hs.add(3);
        hs.add(4);
        hs.add(5);
        hs.add(6);
        hs.add(7);

        //Iteration on HashSet using iterators
        Iterator p = hs.iterator();
        while(p.hasNext()){
            System.out.println(p.next());
        }

        //Iteration using Enhanced for-loop
        for (Integer integer : hs) {
            System.out.println(integer);
        }

        //Linked HashSet- order of insertion is maintained
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Delhi");
        lhs.add("Chandigarh");
        lhs.add("Mumbai");
        lhs.add("Noida");
        lhs.add("Mohali");

        System.out.println(lhs);

        //TreeSet - time complexity of all operations = O(logn) due to sorting
        TreeSet<String> ts = new TreeSet<>(); 
        ts.add("Delhi");
        ts.add("Chandigarh");
        ts.add("Mumbai");
        ts.add("Noida");
        ts.add("Mohali");

        System.out.println(ts);

    }  
}
