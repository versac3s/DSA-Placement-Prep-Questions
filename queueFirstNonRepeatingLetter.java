import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
//FIND THE FIRST NON-REPEATING CHARACTER IN A GIVEN STRING.
public class queueFirstNonRepeatingLetter {
    public static void nonRepeating(String str){
        int freq[]= new int[26];
        Queue<Character> q = new LinkedList<>();
        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;
            //while queue is not empty and the frequency of char is more than 1, remove that element.
            while(!q.isEmpty() && freq[q.peek()-'a']>1){
                q.remove();
            }
            //if queue becomes empty then we have no nonRepeating char so return -1
            if(q.isEmpty()){
                System.out.println(-1+" ");
            }else{//else return the non Repeating element
                System.out.println(q.peek()+ " ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        String str= "aabccxb";
        nonRepeating(str);
    }
}
