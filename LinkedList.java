public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        // create new node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void add(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("Empty list.");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("Empty linked list.");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;

        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int Search_Iterative(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;

    }
    public int helper(Node head, int key){
        if(head==null){
            return-1;
        }
        if(head.data==key){
            return 0; //index
        }
        int index = helper(head.next, key);
        if(index== -1){//if helper function fails to find key
            return -1;
        }return index+1;
    }
    public int Search_Recursive(int key){
        return helper(head,key);

    }
    public void reverse(){
        Node prev = null;
        Node curr= tail = head;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr= next;
        }
        head =prev;
        
    }
    //FIND AND REMOVE NTH NODE FROM END IMPORTANT
    // nth node from back = size -n +1 from front
    public void removeNthNode(int n){
        //calculate size
        int size = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        //remove head
        if(n == size){
            head = head.next;
            return;
        }
        int i = 1;
        int indexFind = size - n;
        Node prev = head;
        while(i<indexFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    public void print() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        ll.print();
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addLast(5);
        ll.add(1, 9);
        ll.print();
        System.out.println();
        
        System.out.println(ll.size);
        
        //ll.removeFirst();
        //ll.removeLast();
        //ll.print();
        
        //System.out.println(ll.Search_Iterative(9));
        //System.out.println(ll.Search_Recursive(8));
        //ll.reverse();
        //ll.print();
        
        ll.removeNthNode(2);
        ll.print();

    }

}
