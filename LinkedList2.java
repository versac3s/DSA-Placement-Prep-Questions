public class LinkedList2 {
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

    // FLOYD'S CYCLE
    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // increment by 1
            fast = fast.next.next; // increment 2
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void removeCycle() {
        // detect cycle
        Node slow = head;
        Node fast = head;
        Boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next; // increment by 1
            fast = fast.next.next; // increment 2
            if (slow == fast) {
                cycle = true;
                break;
            }
        }
        if (cycle = false) {
            return;
        }
        // find meeting point
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        // remove cycle
        prev.next = null;
    }

    private Node middleNode(Node head) {
        Node slow = head;
        Node fast = head.next; // we initialise with head's next so that in case of even no of elements in
                               // list, we get the last node of first half as the middle instead of the first
                               // node of second half.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }
        return slow; // our middle node
    }

    private Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;

    }

    public Node mergeSort(Node head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }
        // find mid
        Node mid = middleNode(head);
        // left and right half
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        // merge
        return merge(newLeft, newRight);
    }

    private Node midNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }
        return slow; // our middle node
    }

    public boolean palindrome() {
        // base case - list is empty or 1 element
        if (head == null || head.next == null) {
            return true;
        }
        // find mid
        Node mid = midNode(head);
        // reverse second half
        Node curr = mid;
        Node prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        mid.next = null;
        Node rightHead = prev; // right half head
        Node left = head;
        // check for palindrome
        while (rightHead != null) {
            if (left.data != rightHead.data) {
                return false;
            }
            left = left.next;
            rightHead = rightHead.next;
        }
        return true;
    }

    public void zigZag() {
        // find the middle node
        Node mid = middleNode(head);
        // left half and right half then reverse right half
        // break the list in halves
        Node current = mid.next; // saved the mid next value in current
        mid.next = null; // broke the list in halves by updating mid next's value
        // reverse
        Node prev = null;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        Node left = head;
        Node right = prev;
        Node nextLeft, nextRight;

        // merge the halves in zig zag form
        while (left != null && right != null) {
            nextLeft = left.next;
            left.next = right;
            nextRight = right.next;
            right.next = nextLeft;

            left = nextLeft;
            right = nextRight;
        }
    }

    public static void main(String[] args) {
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;

        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());

        // LinkedList2 mergeLL = new LinkedList2(); // VERY IMPORTANT
        // mergeLL.addFirst(1);
        // mergeLL.addFirst(2);
        // mergeLL.addFirst(3);
        // mergeLL.addFirst(4);
        // mergeLL.addFirst(5);
        // mergeLL.print();
        // mergeLL.head = mergeLL.mergeSort(mergeLL.head);
        // System.out.println();
        // mergeLL.print();

        // mergeLL.addLast(1);
        // mergeLL.addLast(2);
        // mergeLL.addLast(3);
        // mergeLL.addLast(4);
        // mergeLL.addLast(5);
        // mergeLL.addLast(6);
        // mergeLL.print();
        // mergeLL.zigZag();
        // System.out.println();
        // mergeLL.print();

        LinkedList2 ll = new LinkedList2();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(2);
        ll.addLast(1);
        ll.print();
        System.out.println(ll.palindrome());

    }

}
