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
    
}
