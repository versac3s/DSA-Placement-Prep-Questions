import java.util.HashMap;
import java.util.*;

public class hasMap_ques {
    public static boolean isAnangram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> list = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            list.put(ch, list.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (list.get(ch) != null) {
                if (list.get(ch) == 1) {
                    list.remove(ch);
                } else {
                    list.put(ch, list.get(ch) - 1);
                }
            } else {
                return false;
            }
        }
        return list.isEmpty();
    }

    public static void main(String[] args) {

        // Majority elements: time complexity = O(n)
        // Given an integer array of size n, find all elements that appear more than
        // [n/3] times.
        int arr[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        HashMap<Integer, Integer> nums = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (nums.containsKey(arr[i])) {
                nums.put(arr[i], nums.get(arr[i]) + 1);
            } else {
                nums.put(arr[i], 1);
            }
        }
        for (Integer key : nums.keySet()) {
            if (nums.get(key) > arr.length / 3) {
                System.out.println(key);
            }
        }

        // VALID Anagram time complexity = O(n)
        // Given two strings s and t, return true if t is anagram of s else false.
        // anagram = word formed by rearranging letter of a adifferent word.
        // ie same number of letters and same letters used.

        String s = "race";
        String t = "face";
        System.out.println(isAnangram(s, t));

    }

}
