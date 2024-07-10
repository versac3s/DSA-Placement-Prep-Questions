import java.util.*;

public class StackJCF {
    public static void print(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }

    public static void pushToBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushToBottom(s, data);
        s.push(top);
    }
    //reverse string
    public static void reverseString(String str) {
        Stack<Character> s = new Stack<>();
        int index = 0;
        // from string's index 0 to n we push string in stack
        while (index < str.length()) {
            s.push(str.charAt(index));
            index++;
        }
        // to reverse string in faster way we use stringbuilder
        StringBuilder result = new StringBuilder("");
        while (!s.isEmpty()) {
            char curr = s.pop();
            result.append(curr);
        }
        str = result.toString(); // toString function coz type of string and stringbuilder is different.
        System.out.println(str);
    }
    //reverse a stack
    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushToBottom(s, top);

    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        pushToBottom(s, 4);
        String str = "abcdefg";
        reverseString(str);
        reverseStack(s);
        print(s);
    }

}
