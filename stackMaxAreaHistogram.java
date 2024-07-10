import java.util.*;

public class stackMaxAreaHistogram {
    public static void maxArea(int height[]) {
        int maxArea = 0;
        int nextSmallerRight[] = new int[height.length];
        int nextSmallerLeft[] = new int[height.length];
        // next smallest right
        Stack<Integer> s = new Stack<>();

        for (int i = height.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && height[s.peek()] >= height[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextSmallerRight[i] = height.length;
            } else {
                nextSmallerRight[i] = s.peek();
            }
            s.push(i);
        }
        // next smallest left
        // empty the stack
        s = new Stack<>();
        // logic
        for (int i = 0; i < height.length; i++) {
            while (!s.isEmpty() && height[s.peek()] >= height[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextSmallerLeft[i] = -1;
            } else {
                nextSmallerLeft[i] = s.peek();
            }
            s.push(i);
        }
        // current area
        for (int i = 0; i < height.length; i++) {
            int h = height[i];
            int width = nextSmallerRight[i] - nextSmallerLeft[i] - 1;
            int currArea = h * width;
            maxArea = Math.max(currArea, maxArea);
        }
        System.out.println("Maximum area= " + maxArea);
    }

    public static void main(String[] args) {
        int height[] = { 2, 1, 5, 6, 2, 3 };
        maxArea(height);
    }

}//time complexity = O(n)
