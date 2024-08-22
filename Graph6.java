import java.util.*;

public class Graph6 {
    // Topological Sort
    // A linear order of vertices such that every directed edge u-> v
    // the vertex u comes before v in the order.
    // Topological sort is only applicable on DAGs.
    static class Edge {
        int src, dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // for vertex =0
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        // for vertex =1
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        // for vertex =2
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        // for vertex=3
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        // for vertex =4
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));

    }

    public static void topSort(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i, vis, s);
            }
        }
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        topSort(graph);
    }

}
