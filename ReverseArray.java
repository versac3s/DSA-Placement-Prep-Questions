//this can simply be done by using a loop and forming a new array and the loop traverses each element from the back. 
//But its time complexity and Space complexity is O(n) thus memory and time is at expense.
//Here we use an optimised approach which has constant space complexity (time remains same)
public class ReverseArray {
    public static void reverse(int numbers[]){
        int first = 0, last = numbers.length-1;
        while(first<last){ // swapping
            int temp = numbers[last];
            numbers[last]=numbers[first];
            numbers[first]= temp;
            first++;
            last--;
        }
    } 
    public static void main(String args[]){
        int numbers[]={1,2,3,4,5,6};
        System.out.print("Array reversed = ");
        reverse(numbers);
        for(int i = 0; i<numbers.length;i++){
            System.out.print(numbers[i]+ " ");

        }
    }
    
}
