//BIPARTITE GRAPHS
//The graph which can be divided into two sets U and V such that
//every node can be divided into these sets such that the nodes sharing the same edge
//do not go in the same set.
//graphs that do not contain a cycle (acyclic) are by default Bipartite.
//Cyclic graphs with even nodes are also always Bipartite.
//Cyclic graphs with odd nodes are never Bipartite.
import java.util.*;
import java.util.LinkedList;
import java.util.ArrayList;
public class Graphs5 {
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
        graph[0].add(new Edge(0,2));

        //for vertex =1
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        //for vertex =2
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        //for vertex=3
        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));

        //for vertex =4
        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));

        //accessing neighbors of vertex 2
        for(int i=0; i<graph[2].size(); i++){
            Edge e = graph[2].get(i);
            System.out.println(e.dest);
        }
    }
    public static boolean isBipartite(ArrayList<Edge>[] graph){
        //make an array to store is node is Colored
        //Make the initial value = -1 (i.e. Not coloured)
        //value = 0 => yellow color
        //value = 1 => blue color
        int color[]= new int[graph.length];
        for(int i=0; i<color.length; i++){
            color[i]=-1;
        }

        //Make a queue to store the nodes that we are traversing using BFS traversal
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<graph.length; i++){
            //if the node is not colored yet, it means
            //its not traversed yet. 
            //thus we perform BFS.
            if(color[i]==-1){
                q.add(i);
                color[i] = 0;
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int j = 0; j<graph[curr].size(); j++){
                        Edge e = graph[curr].get(j);

                        if(color[e.dest]==-1){
                            int nextColor = color[curr] == 0 ? 1: 0;
                            color[e.dest] = nextColor;
                            q.add(e.dest);
                        }else if(color[e.dest] == color[curr]){
                            return false;
                        }
                    }
                }

            }
        }
        return true;
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[]= new ArrayList[V];
        createGraph(graph);
        System.out.println(isBipartite(graph));
    }
    
}
