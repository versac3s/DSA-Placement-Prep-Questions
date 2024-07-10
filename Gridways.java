//BACKTRACKING- GRID WAYS 
//Find number of ways from (0,0) to (N-1,M-1) in a NXM Grid.
//Allowed moves - right and down
public class Gridways {
    // public static int gridways(int i, int j, int n, int m){
    // //base case
    // if(i==n-1 || j==m-1){
    // return 1;
    // }else if(i==n || j==m){ //if we reach outside the boundary
    // return 0;
    // }
    // int way1= gridways(i+1,j,n,m);
    // int way2= gridways(i,j+1,n,m);
    // return way1+way2;
    // }
    public static int factorial(int n) {
        // base case
        if (n == 0) {
            return 1;
        }
        int n_fac = factorial(n - 1);
        int n_fact = n * n_fac;
        return n_fact;
    }

    public static int gridways(int i, int j, int n, int m) {
        int ways = factorial(n-1 + m-1)/(factorial(n-1)*factorial(m-1));
        return ways;
    }

    public static void main(String args[]) {
        int n = 3;
        int m = 3;
        System.out.println(gridways(0, 0, n, m));

    }

}
// number of right turns = no of columns m
// number of down = no of rows n
// time complexity = 2^n+m

// total characters = n-1 + m-1
// using permutation, number of ways= (n-1 + m-1)! / (n-1)!(m-1)!
//thus time complexity = O(n) now :)))