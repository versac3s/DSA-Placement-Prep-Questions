import java.util.*;
import java.util.ArrayList;

//For given n lines on x-axis, use 2 lines to form a container such that
//it holds maximum water. Time complexity = O(n) using 2 pointer approach
public class ArrayList_ContainMostWater {
    public static int storeWater(ArrayList<Integer> height) {
        int maxWater = 0;
        int leftPointer = 0;
        int rightPointer = height.size() - 1;
        while (leftPointer < rightPointer) {
            int h = Math.min(height.get(leftPointer), height.get(rightPointer));
            int w = rightPointer - leftPointer;
            // area of water stored
            int currWater = h * w;
            maxWater = Math.max(maxWater, currWater);

            if (height.get(leftPointer) < height.get(rightPointer)) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println(storeWater(height));
    }

}
