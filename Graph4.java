import java.util.*;
public class Graph4 {
    static class Edge{
        int src, dest;

        public Edge(int s, int d){
            this.src=s;
            this.dest=d;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]){
        
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        //for vertex =0
        graph[0].add(new Edge(0,1));

        //for vertex =1
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,3));

        //for vertex =2
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));
        graph[2].add(new Edge(2,4));

        //for vertex=3
        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,2));

        //for vertex =4
        graph[4].add(new Edge(4,2));

        //accessing neighbors of vertex 2
        for(int i=0; i<graph[2].size(); i++){
            Edge e = graph[2].get(i);
            System.out.println(e.dest);
        }
    }
    //CYCLE DETECTION

    //In Undirected Graph time comp =O(v+e)
    public static boolean detectCycle(ArrayList<Edge>[] graph){
        boolean vis[]= new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                if(detectCycleUtil(graph, vis, i, -1)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int par){
        vis[curr]= true;
        for(int i=0; i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(!vis[e.dest]){
                if(detectCycleUtil(graph, vis, e.dest, curr)){
                    return true;
                }
            }else if(vis[e.dest] && e.dest !=par){
                return true;
            }
        } 
        return false;
    }
    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        System.out.println(detectCycle(graph));
    }
}
