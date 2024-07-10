//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining
public class TRAPRAINWATER {
    public static int trappedwater(int height[]){
        int n = height.length;
        int leftmax[] = new int[height.length];
        leftmax[0]= height[0];
        for(int i = 1; i<height.length; i++){
            leftmax[i]= Math.max(height[i], leftmax[i-1]);
        }
        int rightmax[]= new int[height.length];
        rightmax[n-1]= height[n-1];
        for(int i = n-2; i>=0; i--){
            rightmax[i]=Math.max(height[i], rightmax[i+1]);
        }
        int trapwater = 0;
        for (int i =0; i<n; i++){
            int waterlevel = Math.min(leftmax[i], rightmax[i]);
            trapwater += waterlevel - height[i];
        }
        return trapwater;
    }
    //(waterlevel - barlevel)*width = trapped water
   public static void main(String args[]){
    int height[]= {4,2,0,6,3,2,5};
    System.out.println(trappedwater(height));
   } 
}
//time complexity = O(n) n = no of bars
// we also use auxiliary arrays in this