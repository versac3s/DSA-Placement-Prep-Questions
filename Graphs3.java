import java.util.*;
import java.util.LinkedList;
public class Graphs3 {
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
    //CONNECTED COMPONENTS
    //In a graph, there is no compulsion for the entire to be connected.
    //Thus, it might not be possible for us to traverse the graph with single source.
    //So we modify the previous traversal strategy.

    //We make a new helping function, which stores all the visited[curr] as false.
    //We start with source, call the bfs/dfsUtil function, traverse and make the vis[curr]=true.
    //Then we see for which node is the vis[curr] = false. 
    //We go to that node and then start again with the traversal.

    public static void bfs(ArrayList<Edge>[] graph){
        boolean visited[] = new boolean[graph.length];
        for(int i=0; i<graph.length;i++){
            if(!visited[i]){
                bfsUtil(graph, visited);
            }
        }
    }
    public static void bfsUtil(ArrayList<Edge>[] graph, boolean visited[]){
        Queue<Integer> q = new LinkedList<>();
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

    public static void dfs(ArrayList<Edge>[] graph){
        boolean visited[]= new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            dfsUtil(graph, i, visited);
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean visited[]){
        System.out.println(curr);
        visited[curr]=true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                dfsUtil(graph, e.dest, visited);
            }
        }
    }
    
}
