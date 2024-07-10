//possible number of pairs in array
//IMPORTANT
public class NumofPairs {
    public static void printPairs(int array[]){
        int tp = 0; //total pairs = (n*n-1)/2 IMPORTANT
        for (int i = 0; i<array.length;i++){
            int current = array[i];
            for (int j = i+1; j<array.length; j++){
                System.out.print("("+current+","+array[j]+")");
                tp++;
            }
            System.out.println(" ");
        }
        System.out.println("Total pairs =" + tp);
    }
    public static void main(String args[]){
        int numbers[]={1,2,3,4,5,6,7,8,9};
        printPairs(numbers);
    }
}
//Time complexity = O(n^2)
