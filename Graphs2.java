//TRAVERSAL OF GRAPHS - BFS AND DFS

import java.util.ArrayList;
import java.util.*;
import java.util.LinkedList;

public class Graphs2 {
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
    static void createGraph(ArrayList<Edge> graph[]){
        
        for(int i=0; i<graph.length; i++){
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
    //BFS TRAVERSAL - Go to immediate neighbors first (like level order in trees)
    //Data Structure required : Queue
    //Time complexity = O(V+E) for adjacency lists if we made a matrix, its time would be O(v^2)
    public static void bfs(ArrayList<Edge>[] graph){
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];
        q.add(0); //source
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!visited[curr]){
                System.out.println(curr + " ");
                visited[curr]=true;
                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    //DFS TRAVERSAL
    //Keep moving to the first neighbor
    //Data Structure : Implicit Stack (using recursion)
    //Time Complexity = O(e+v)
    
    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean visited[]){
        //visit
        System.out.println(curr + " ");
        visited[curr]=true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                dfs(graph, e.dest, visited);
            }
        }
    }

    //Has Path?
    //For given source and destination if a path exists.
    //using dfs thus, time complexity = 0(e+v)
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean vis[]){
        if(src==dest){
            return true;
        }
        vis[src]=true;
        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            if(!vis[e.dest] && hasPath(graph, e.dest, dest ,vis)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int vertices =5;
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        createGraph(graph);
        System.out.println();
        bfs(graph);
        System.out.println();
        dfs(graph, 0, new boolean[vertices]);
        System.out.println(hasPath(graph, 0, 5, new boolean[vertices]));
    }
    
}
