import java.util.*;
public class Graphs1 {
    //class to store info about edges
    static class Edge{
        int src;
        int dest;
        int weight;

        //constructor
        public Edge(int s, int d, int w){
            this.src=s;
            this.dest=d;
            this.weight=w;
        }
    }
    public static void main(String[] args) {
        
        //no of vertices = size of array
        int vertices=5;
        
        //Define an array called graph which is of the size 'vertices'
        //and this array hold Edges in the form of arrayList.
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        
        //rn at every index we have null value ie array with no arraylist in it.
        //so we initialise an empty arrayList where we can store our edges.
        for(int i=0; i<vertices; i++){
            graph[i] = new ArrayList<>();
        }

        //for vertex =0
        graph[0].add(new Edge(0,1,5));

        //for vertex =1
        graph[1].add(new Edge(1,0,5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));

        //for vertex =2
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,2));

        //for vertex=3
        graph[3].add(new Edge(3,1,3));
        graph[3].add(new Edge(3,2,1));

        //for vertex =4
        graph[4].add(new Edge(4,2,2));

        //accessing neighbors of vertex 2
        for(int i=0; i<graph[2].size(); i++){
            Edge e = graph[2].get(i);
            System.out.println(e.dest);
        }
        
    }
    
}
