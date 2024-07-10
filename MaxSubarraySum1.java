public class MaxSubarraySum1 {
    public static void Subarrays(int numbers[]){
        int current_sum = 0;
        int max_sum = Integer.MIN_VALUE;
        for(int i = 0; i<numbers.length;i++){
            int start = i;
            for(int j = i; j<numbers.length;j++){
                int end = j;
                current_sum=0;
                for(int k = start; k<=end; k++){
                    current_sum += numbers[k];
                }
                System.out.println(current_sum);
                System.out.println(" ");
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
// time complexity is O(n3) which is bad. this is called the brute force approach and 
// its basic. next we will try to optimize and use prefix approach.