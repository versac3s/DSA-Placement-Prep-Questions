import java.util.*;
import java.util.PriorityQueue;

public class Heaps {
    // Priority Queues : Type of queue that arranges elements based on
    // their priority levels. Unlike queue it does not follow FIFO order as the
    // elements are retrieved based on their priority.
    //PQ are implemented using Heaps.
    
    //class of student object where we need to sort students based on their rank
    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }

    public static void main(String[] args) {
        // Implementation of PQ using JCF
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Operations in PQ

        // add operation with time complexity O(logn)
        pq.add(4);
        pq.add(1);
        pq.add(3);
        pq.add(8);
        pq.add(5);
        pq.add(6);
        while (!pq.isEmpty()) {
            System.out.println(pq.peek()); // Time complexity = O(1)
            pq.remove(); // Time complexity = O(logn)
        }
        System.out.println();
        //Adding object 'Student' to PQ
        PriorityQueue<Student> st = new PriorityQueue<>();
        st.add(new Student("A", 13));
        st.add(new Student("B", 2));
        st.add(new Student("C", 13));
        st.add(new Student("D", 5));
        st.add(new Student("E", 10));
        while(!st.isEmpty()){
            System.out.println(st.peek().name + " " + st.peek().rank);
            st.remove();
        }

    }

}
