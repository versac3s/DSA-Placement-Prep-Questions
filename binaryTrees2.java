import java.util.*;

public class binaryTrees2 {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    };

    // Kth level of Tree
    public static void klevel(Node root, int level, int k) {
        if (root == null) {
            return;
        }
        if (level == k) {
            System.out.println(root.data);
            return;
        }
        klevel(root.left, level + 1, k);
        klevel(root.right, level + 1, k);
    }

    // Lowest common ancestor, TIME COMPLEXITY = LINEAR, Approach 1
    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root.data == n) {
            return true;
        }
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);
        if (foundLeft || foundRight) {
            return true;
        }
        // if node not found anywhere, remove it
        path.remove(path.size() - 1);
        return false;
    }

    public static Node lca(Node root, int n1, int n2) {
        // find path from root to node
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        getPath(root, n1, path1);
        getPath(root, n2, path2);
        // calculate lowest common ancestor lca
        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }
        Node lca = path1.get(i - 1);
        return lca;
    }
    //APPROACH 2
    public static Node lca2(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        // case where leftLCA= valid but rightLCA=null
        if (rightLca == null) {
            return leftLca;
        }
        if (leftLca == null) {
            return rightLca;
        }
        // case where no null was returned from any side
        // then we have found lca
        return root;
    }

    //MINIMUM DISTANCE bw TWO NODES 
    public static int lcaDist(Node root, int n){
        if(root == null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int leftDist = lcaDist(root.left,n);
        int rightDist=lcaDist(root.right, n);
        //nodes were not found
        if(leftDist == -1 && rightDist == -1){
            return -1;
        }else if(leftDist == -1){ //node in right subtree
            return rightDist + 1;
        }else{
            return leftDist+1; //node found in left subtree
        }
    }
    public static int minDistance(Node root, int n1, int n2){
        Node lca= lca2(root, n1, n2);
        int dist1 = lcaDist(lca,n1);
        int dist2=lcaDist(lca, n2);
        return dist1+dist2;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(5);
        klevel(root, 1, 2);
        System.out.println("LCA=" + lca2(root, 2, 3).data);
        System.out.println("Minimum distance= " +minDistance(root, 2,3));
    }
}
