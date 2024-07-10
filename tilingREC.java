//tilling problem- no. of ways to tile with axb size of tiles a given board of nxm dimensions
//a=width=2, b=length=1, tile = 2xn
//tiles can be placed horiontally or vertically
public class tilingREC {
    public static int tiling(int n){ //floor length 
        //base case
        if(n == 0|| n==1){
            return 1;
        }
        //we have to make choice of how to lay the tile
        //vertical choice
        int verticalTiles = tiling(n-1);
        //horizontal choice
        int horizontalTiles= tiling(n-2);
        int totalWays= verticalTiles + horizontalTiles;
        return totalWays;
    }
    public static void main(String args[]){
        System.out.println(tiling(4));
    }        

}
