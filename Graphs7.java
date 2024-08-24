import java.util.*;
public class Graphs7 {
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
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        //for vertex =1
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,7));

        //for vertex =2
        graph[2].add(new Edge(2,4,3));

        //for vertex=3
        graph[3].add(new Edge(3,5,1));

        //for vertex =4
        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));
    }
    
    //DIJKSTRA'S ALGORITHM time complexity = V + ElogV because of using PQ
    //Shortest path from sources to all vertices in weighted graph
    //Using a Priority Queue (min heap)

    //making a pair class of (node, weight) ie the node and the weight with it.
    static class Pair implements Comparable<Pair>{
        int n;
         int path;
        public Pair(int n, int path){
            this.n=n;
            this.path=path;
        }
        @Override
        public int compareTo(Pair p2){
            //whichever value is smaller, PQ return that value.
            return this.path - p2.path;
        }
    }
    public static void dijsktra(ArrayList<Edge> graph[], int src){
        int distance[]= new int[graph.length];
        for(int i=0; i<graph.length; i++){
            //if i is not the source itself, mark the distance from source to all nodes as infinity.
            if(i!=src){
                distance[i] = Integer.MAX_VALUE;
            }
        }
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.n]){
                vis[curr.n]= true;
                for(int i=0; i< graph[curr.n].size(); i++){
                    Edge e = graph[curr.n].get(i);
                    int u = e.src, v = e.dest, wt = e.weight;
                    //update distance of src to v
                    if(distance[u] + wt < distance[v]){
                        distance[v] = distance[u]+wt;
                        pq.add(new Pair(v, distance[v]));
                    }
                }
            }
        }
        for(int i = 0; i<distance.length; i++){
            System.out.print(distance[i]+" ");
        }
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[]= new ArrayList[V];
        createGraph(graph);
        int src = 0;
        dijsktra(graph, src);
    }
    
}
