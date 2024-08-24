import java.util.*;
import java.util.LinkedList;

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

    // TOPOLOGICAL SORT using DFS approach
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

    // TOPOLOGICAL SORT using BFS (KAHN'S ALGORITHM)
    public static void inDegree(ArrayList<Edge> graph[], int inDeg[]) {
        for (int i = 0; i < graph.length; i++) {
            int vertex = i;
            for (int j = 0; j < graph[vertex].size(); j++) {
                Edge e = graph[vertex].get(i);
                inDeg[e.dest]++;
            }
        }
    }

    public static void topSortBFS(ArrayList<Edge> graph[]) {
        int inDegree[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            // if indegree = 0; add the node to queue
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            // remove and print the added node from queue
            int curr = q.remove();
            System.out.println(curr);
            // for the neighbors of the above node printed, subtract 1 from neighbors
            // inDegree.
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                inDegree[e.dest]--;
                if (inDegree[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
    }

    // ALL PATHS FROM SOURCE TO TARGET in directed graph using Recursion.
    // (exponential time complexity)
    public static void allPaths(ArrayList<Edge> graph[], int src, int dest, String path) {
        if (src == dest) {
            System.out.println(path + dest);
            return;
        }
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            allPaths(graph, e.dest, dest, path + src+" -> ");
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        topSort(graph);
        int src = 0;
        int dest = 3;
        allPaths(graph, src, dest, "");
    }

}
