public class backtracking {
    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

    public static void modifyArray(int arr[], int i, int val) {
        // base case
        if (i == arr.length) {
            print(arr);
            return;
        }
        // recursion
        arr[i] = val;
        modifyArray(arr, i + 1, val + 1);// function call
        arr[i] = arr[i] - 2;// backtracking step
    }

    public static void findSubset(String str, String ans, int i) {
        // base case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }
        // recursion
        findSubset(str, ans + str.charAt(i), i + 1);
        findSubset(str, ans, i + 1);
    }

    public static void permutation(String input, String answer) {
        // base case
        if (input.length() == 0) {
            System.out.println(answer);
            return;
        }
        // recursion
        for (int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            // removing the chosen char from string input
            String newinput = input.substring(0, i) + input.substring(i + 1);
            // add the char in ans
            permutation(newinput, answer + curr);
        }
    }

    public static void main(String args[]) {
        int arr[] = new int[7];
        modifyArray(arr, 0, 1);
        print(arr);
        System.out.println();
        String str = "abc";
        findSubset(str, "", 0);
        System.out.println();
        permutation(str, "");
    }
}
// time complexity= O(n)
// space = O(n)

// time complexity = O(n*2^n)