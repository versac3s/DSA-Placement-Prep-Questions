public class RotatedSort {
    public static int search(int arr[], int target, int start, int end){
        if(start>end){
            return -1; //base
        }
        int mid= (start+end)/2;
        if(arr[mid]==target){
            return mid;
        }
        if(arr[start]<=arr[mid]){
            if(arr[start]<=target && target<=arr[mid]){
                //target is on line 1
                return search(arr, target, start, mid-1);

            }else{
                return search(arr, target, mid+1,end);
            }
        }
        
        else{
            if(arr[mid]<=target && target<=arr[end]){
                //target is on line 2
                search(arr, target, mid+1, end);
            }else{
                return search(arr, target, start, mid-1);
            }
        }
        return 1;
    }
    public static void main (String args[]){
        int arr[]={4,5,6,7,0,1,2};
        int target =6;
        int tar = search(arr, target, 0, arr.length-1);
        System.out.println("Index = "+tar);
    }
    
}
