import java.util.*;
import java.util.PriorityQueue;

public class Heaps3 {
//Ques 1.
//K-NEAREST
//We are given N points in a 2D plane which are locations of N cars.
//If we are at the origin, print the nearest K cars. K=2
    static class Point implements Comparable<Point> {
        int x, y;
        int dist; // considering square of distance
        int index; //to print the index and not the address of the car's location.

        public Point(int x, int y, int dist, int index) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.index=index;
        }

        @Override
        public int compareTo(Point p2) {
            return this.dist - p2.dist;
        }
    }

    public static void main(String[] args) {
        int pts[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < pts.length; i++) {
            //distance formula
            int dist = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
            pq.add(new Point(pts[i][0], pts[i][1], dist, i));
        }
        for(int i=0; i<k;i++){
            System.out.println(pq.remove().index+" ");
        }
//Ques 2.
//Given are N ropes of different lengths, the task is to connect these ropes into one rope
//with minimum cost, such that cost to connect two ropes is equal to sum of their lengths.
//Approach : pick minimum cost ropes first
        int ropes[]={2,3,3,4,6};
        PriorityQueue<Integer> rope = new PriorityQueue<>();
        for(int i=0; i<ropes.length; i++){
            rope.add(ropes[i]);
        }
        int cost=0;
        while(rope.size() >1){
            int min = rope.remove();
            int min2=rope.remove();
            cost += min+min2;
            rope.add(min+min2);
        }
        System.out.println("cost= "+ cost);
    }
    //Doing this question with a greedy approach will not be efficient.
    //if greedy is applied, cost = 43.

}
