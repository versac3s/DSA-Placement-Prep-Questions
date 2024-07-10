public class Subarray {
    public static void printSubarrays(int numbers[]){
        int total_sub = 0;
        for(int i =0; i<=numbers.length; i++){
            int start = i;
            for( int j = i; j<numbers.length; j++){ //j starts from i so that we can include single element
                int end = j;
                for(int k=start; k<=end; k++){ //to print our array
                    System.out.print(numbers[k]+" ");
                }
                total_sub++;
                System.out.println();
            }
            System.out.println();
            System.out.println("Total subarrays= " + total_sub);
        }
    }
    public static void main(String args[]){
        int numbers[]={2,3,4,5,6};
        printSubarrays(numbers);
        
    }
}
