import java.util.*;
public class Heaps2 {
    //OPERATIONS IN HEAPS
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        //INSERTION time complexity = O(logn)
        public void add(int data){
            arr.add(data);
            int child = arr.size()-1; //x is child index
            int parent = (arr.size()-2)/2; //parent index
            //this loop has time complexity of logn
            while(arr.get(child)<arr.get(parent)){
                //swap
                int temp = arr.get(child);
                arr.set(child, arr.get(parent));
                arr.set(parent, temp);
                //update pointers
                child = parent;
                parent = (child-1)/2;
            }
        }

        //PEEK - getting min element from heap time complexity = O(1)
        public int peek(){
            return arr.get(0); //since in min heap the minimum element is at the root ie on index 0 of array
        }

        //REMOVE - removing the
        private void heapify(int i){
            //for root i check left and right child
            int left = 2*i+1;
            int right =2*i+2;
            //assume minimum index is root
            int minIndex =i;
            //check that we are not examining a leaf node (as it wont have a left or right child)
            //then if the minIndex value is more than the left child,
            //make left child the new minimum value.
            if(left<arr.size() && arr.get(minIndex)> arr.get(left)){
                minIndex = left;
            }
            //same for right child.
            if(right<arr.size() && arr.get(minIndex)> arr.get(right)){
                minIndex =right;
            }
            //if there was a change in the minimum value from above conditions,
            //we swap the the values.
            //for ex. is left child had the minimum value we swap their vals
            //and make the left child the new root.
            if(minIndex != i){
                //swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIndex));
                arr.set(minIndex, temp);
                heapify(minIndex);
            }
        }
        public int remove(){
            int data = arr.get(0);

            //swap first and last index
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);

            //delete the new last element
            arr.remove(arr.size()-1);

            //heapify
            heapify(0);
            return data;
        }

        public boolean isEmpty(){
            return arr.size()==0;
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);
        while(!h.isEmpty()){
            System.out.println(h.peek());
            h.remove();
        }
    }
}
