//given queue= 1 2 3 4 5 6 7 8 9 10
//output queue= 1 6 2 7 3 8 4 9 5 10
//time complextiy = O(n), space=O(n)
import java.util.*;
import java.util.LinkedList;
public class queueInterleave {
    public static void interLeave(Queue<Integer> q){
    Queue<Integer> firstHalf= new LinkedList<>();
    int size= q.size();
    for(int i=0; i<size/2; i++){
        firstHalf.add(q.remove());
    }
    while(!firstHalf.isEmpty()){
        q.add(firstHalf.remove());
        q.add(q.remove());
    }
}
public static void main(String[] args) {
    Queue<Integer> q= new LinkedList<>();
    q.add(1);
    q.add(2);
    q.add(3);
    q.add(4);
    q.add(5);
    q.add(6);
    q.add(7);
    q.add(8);
    q.add(9);
    q.add(10);
    q.add(11);
    q.add(12);
    interLeave(q);
    while(!q.isEmpty()){
        System.out.println(q.remove()+ " ");
        
    }
}
}