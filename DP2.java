import java.util.*;
public class DP2 {
    public static void print(int dp[][]){
        for(int i = 0; i<dp.length; i++){
            for(int j = 0; j<dp[0].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    //0-1 KNAPSACK PROBLEM
    public static int knapsackTab(int val[], int wt[], int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        for(int i=0; i<dp.length; i++){// 0th col
            dp[i][0] = 0;
        }
        for(int j = 0; j<dp[0].length; j++){
            dp[0][j]=0;
        }
        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<W+1; j++){
                int v = val[i-1];// ith item value
                int w = wt[i-1]; // ith item weight
                if(w<=j){
                    int includeProfit = v+ dp[i-1][j-w];
                    int excludeProfit = dp[i-1][j];
                    dp[i][j] = Math.max(includeProfit, excludeProfit);
                }else{
                    int excludeProfit = dp[i-1][j];
                    dp[i][j] = excludeProfit;
                }
            }
        }
        print(dp);
        return dp[n][W];
    }
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int weight[]={2,5,1,3,4};
        int W = 7;
        int dp[][] = new int[val.length+1][W+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println("Max profit= "+ knapsackTab(val, weight, W));

    }
    
}
