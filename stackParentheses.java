import java.util.*;
public class stackParentheses {
    //push opening bracket in stack
    //for closing bracket, if top and it form a pair, pop. else return false.
    //also check if stack is not empty and string is finished, then also we return false.
    public static boolean isValid(String str){
        Stack<Character> s = new Stack<>();
        for(int i = 0; i<str.length();i++){
            char ch = str.charAt(i);
            //opening
            if(ch == '(' || ch=='{' || ch=='['){
                s.push(ch);
            }else{
                //closing
                if(s.isEmpty()){
                    return false;
                }
                if((s.peek()=='(' && ch ==')')
                || (s.peek()=='{' && ch=='}')
                || (s.peek()=='[' && ch==']')){
                    s.pop();
                }else{
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isDuplicate(String str){
        Stack<Character> s = new Stack<>();
        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            //closing
            if(ch ==')'){
                int count=0;
                while(s.pop()!='('){
                    s.pop();
                    count++;
                }
                if(count<1){
                    return true;
                }
            }else{
                //opening
                s.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) {
      
        // String str="{[()]}(";
        // System.out.println(isValid(str));
        String str = "(a+b)";
        System.out.println(isDuplicate(str));
    }
}
//time complexity = O(n)