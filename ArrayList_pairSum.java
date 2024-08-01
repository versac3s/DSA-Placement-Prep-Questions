
//find any pair in a Sorted array has a target sum
//BRUTE FORCE, Time complexity = O(n)
import java.util.*;

public class ArrayList_pairSum {
    public static boolean pairSum(ArrayList<Integer> list, int target) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // optimized two pointer approach, only applicable if array list is sorted
    public static boolean pairSum1(ArrayList<Integer> list, int target) {
        int leftPointer = 0;
        int rightPointer = list.size() - 1;
        while (leftPointer != rightPointer) {
            if (list.get(leftPointer) + list.get(rightPointer) == target) {
                return true;
            }
            if (list.get(leftPointer) + list.get(rightPointer) < target) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }
        return false;
    }

    // Find if pair sum in a Sorted And Rotated ArrayList has a target sum. Time complexity = O(n)

    public static boolean pairSumRotated(ArrayList<Integer> list1, int target) {
        // find pivot where pivot = point where our array broke the sorted order.
        int pivot = -1;
        int n = list1.size();

        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) > list1.get(i + 1)) {
                pivot = i;
                break;
            }
        }

        int leftPointer = pivot + 1; // smallest element
        int rightPointer = pivot; // largest element

        // while my lp is not equal to rp, we use Modulo because we want our pointers to
        // move in rotation
        while (leftPointer != rightPointer) {
            // case1
            if (list1.get(leftPointer) + list1.get(rightPointer) == target) {
                return true;
            }
            // case2
            if (list1.get(leftPointer) + list1.get(rightPointer) < target) {
                leftPointer = (leftPointer + 1) % n;
            } else {
                rightPointer = (n + rightPointer - 1) % n;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int target = 5;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(pairSum(list, target));
        System.out.println(pairSum1(list, target));
        // sorted and rotated array (brute force can be used to find this as well)
        int target1 = 16;
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(11);
        list1.add(15);
        list1.add(6);
        list1.add(8);
        list1.add(9);
        list1.add(10);
        System.out.println(pairSumRotated(list1, target1));

    }
}
