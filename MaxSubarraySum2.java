//prefix approach with time complexity O(n2)
public class MaxSubarraySum2 {
    public static void Subarrays(int numbers[]){
        int current_sum = 0;
        int max_sum = Integer.MIN_VALUE;
        int prefix[]= new int[numbers.length];
        prefix[0] = numbers[0];
        //calculating prefix array
        for(int i =1; i<prefix.length;i++){
            prefix[i] = prefix[i-1]+numbers[i]; // previous sum + current index
        }
        for(int i = 0; i<numbers.length;i++){
            int start = i;
            for(int j = i; j<numbers.length;j++){
                int end = j;
                current_sum= start ==0 ? prefix[end] : prefix[end] - prefix[start-1]; //formula
                
                if(max_sum < current_sum){
                    max_sum = current_sum;
                }
            }
        }
        System.out.println("Maximum sum = "+max_sum);
    }
    public static void main(String args[]){
        int numbers[]= {2,4,6,8,10};
        Subarrays(numbers);
    } 
}
