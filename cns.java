
import java.util.*;

class Node {
    int id;
    int[][] routingTable;
    int numNeighbors;
    Node[] neighbors;
    static final int MAX_NODES = 10;
    public Node(int id, int maxNodes) {
        this.id = id;
        this.routingTable = new int[maxNodes][3];
        this.numNeighbors = 0;
        this.neighbors = new Node[maxNodes];
    }
}

public class cns {
    static final int MAX_NODES = 10;

    public static void main(String[] args) {
        Node[] nodes = new Node[MAX_NODES];

        for (int i = 0; i < MAX_NODES; i++) {
            nodes[i] = new Node(i, MAX_NODES);
        }

        addNeighbor(nodes[0], nodes[1]);
        addNeighbor(nodes[0], nodes[2]);
        addNeighbor(nodes[1], nodes[0]);
        addNeighbor(nodes[1], nodes[3]);
        addNeighbor(nodes[2], nodes[0]);
        addNeighbor(nodes[2], nodes[3]);
        addNeighbor(nodes[3], nodes[1]);
        addNeighbor(nodes[3], nodes[2]);

        int convergence = 0;
        int iteration = 0;

        while (convergence != 1) {
            convergence = 1;
            System.out.println("Iteration " + iteration);

            for (int i = 0; i < MAX_NODES; i++) {
                updateRoutingTable(nodes[i]);
            }

            for (int i = 0; i < MAX_NODES; i++) {
                for (int j = 0; j < MAX_NODES; j++) {
                    if (nodes[i].routingTable[j][0] != -1 && nodes[i].routingTable[j][2] != nodes[i].routingTable[j][2]) {
                        convergence = 0;
                        break;
                    }
                }
                if (convergence != 1) {
                    break;
                }
            }

            for (int i = 0; i < MAX_NODES; i++) {
                printRoutingTable(nodes[i]);
            }

            iteration++;
            System.out.println();
        }
    }

    static void addNeighbor(Node node, Node neighbor) {
        if (node.numNeighbors < MAX_NODES) {
            node.neighbors[node.numNeighbors] = neighbor;
            node.numNeighbors++;
        }
    }

    static void updateRoutingTable(Node node) {
        for (int i = 0; i < node.numNeighbors; i++) {
            Node neighbor = node.neighbors[i];
            for (int j = 0; j < MAX_NODES; j++) {
                if (neighbor.routingTable[j][0] != -1) {
                    int destination = neighbor.routingTable[j][0];
                    int cost = neighbor.routingTable[j][2];
                    int totalCost = cost + 1;
                    if (node.routingTable[destination][0] == -1 || totalCost < node.routingTable[destination][2]) {
                        node.routingTable[destination][0] = destination;
                        node.routingTable[destination][1] = neighbor.id;
                        node.routingTable[destination][2] = totalCost;
                    }
                }
            }
        }
    }

    static void printRoutingTable(Node node) {
        System.out.println("Routing table of Node " + node.id + ":");
        System.out.println("---------------------------");
        System.out.println("| Destination | Next Hop | Cost |");
        System.out.println("---------------------------");
        for (int i = 0; i < MAX_NODES; i++) {
            if (node.routingTable[i][0] != -1) {
                System.out.printf("|     %2d      |    %2d    |  %2d  |\n", node.routingTable[i][0], node.routingTable[i][1], node.routingTable[i][2]);
            }
        }
        System.out.println("---------------------------");
    }
}
