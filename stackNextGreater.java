import java.util.*;
public class stackNextGreater {
    public static void main(String[] args) {
        int arr[]={6,8,0,1,3};
        Stack<Integer>s=new Stack<>();
        int nextGreater[] = new int[arr.length];
        //because we are asked next greater in right direction. if it was left we can reverse the loop
        for(int i =arr.length-1; i>=0; i--){
            //change the comparision operater here if smallest is asked
            while(!s.isEmpty() && arr[s.peek()]<= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nextGreater[i]=-1;
            }else{
                nextGreater[i]=arr[s.peek()];
            }
            s.push(i); //pushing index
        }
        for(int i =0; i<nextGreater.length; i++){
            System.out.println(nextGreater[i]+" ");
        }
    }
    
}
//OHTER FORMS: 
//next greater in left
//next smallest in left and right
