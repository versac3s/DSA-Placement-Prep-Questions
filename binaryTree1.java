import java.util.*;
import java.util.LinkedList;
public class binaryTree1 {
    //Contructing a binary tree in preorder Time complexity = O(n)
    //Node class
    static class Node{
        int data;
        Node left;
        Node right;
        //contructor
        Node(int data){
            this.data = data;
            this.left=null;
            this.right = null;
        }
    }
    //Binary tree class
    static class BinaryTree{
        static int index = -1; //index static coz we want index to update at every node in every recursion
        //function to build tree
        public static Node buildTree(int node[]){
            index++;
            if(node[index] == -1){
                return null;
            }
            //make a new node at the index and use recursion to further build LST and RST (sub trees)
            Node newNode = new Node(node[index]);
            newNode.left = buildTree(node);
            newNode.right = buildTree(node);
            return newNode;
        }
        //TRAVERSAL in PREORDER time complexity = O(n)
        public static void preorder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }

        //TRAVERSAL in INORDER time complexity = O(n)
        public static void inorder(Node root){
            if(root == null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }

        //TRAVERSAL in POSTORDER time complexity = O(n)
        public static void postorder(Node root){
            if(root == null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+ " ");
        }

        //TRAVERSAL in LEVEL ORDER time complexity = O(n)
        public static void levelorder(Node root){
            if(root == null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null); //tells compiler when new level starts
            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode== null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left !=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right !=null){
                        q.add(currNode.right);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        int node[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(node);
        
        tree.preorder(root);
        System.out.println();
        tree.inorder(root);
        System.out.println();
        tree.postorder(root);
        System.out.println();
        tree.levelorder(root);
    }
    
}
