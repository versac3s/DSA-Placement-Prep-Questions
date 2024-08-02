import java.util.*;
public class hashing_ques {
    public static void main(String[] args) {
        //COUNT DISTINCT ELEMENTS IN ARRAY time complexity = O(n)
        //it does not count the duplicate values.
        int num[]= {4,3,2,5,6,7,3,4,2,1};
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i<num.length; i++){
            hs.add(num[i]);
        }
        System.out.println("Number of distinct elements= "+ hs.size());

        //UNION & INTERSECTION OF 2 ARRAYS
        int arr1[]={7,3,9};
        int arr2[]={6,3,9,2,9,4};
        HashSet<Integer> set = new HashSet<>();
        for(int i =0; i<arr1.length; i++){
            set.add(arr1[i]);
        }
        for(int i =0; i<arr2.length; i++){
            set.add(arr2[i]);
        }
        System.out.println("Union ="+ set.size()+" Set = "+ set);

        set.clear();

        //for intersection, we add all elements of first array in empty set 
        //then we check from second array if the element exists in the set.
        //if yes then that element is our intersection.
        for(int i = 0; i<arr1.length; i++){
            set.add(arr1[i]);
        }
        int count =0;
        for(int i = 0; i<arr2.length; i++){
            if(set.contains(arr2[i])){
                count++;
                //we remove the same elements
                set.remove(arr2[i]);
            }
        }
        System.out.println("Intersection ="+ count);
    }
    
}
