public class SpiralMatrix{
    public static void printSpiral(int matrix[][]){
        int startrow=0;
        int startcol=0;
        int endrow= matrix.length-1;
        int endcol= matrix[0].length-1;
        while(startrow<=endrow && startcol<=endcol){ // we use && because we want to use this for n x m matrix too and not just n x n.
            //top boundary j=col, i = row
            for(int j=startcol; j<=endcol; j++){
                System.out.print(matrix[startrow][j]+" ");
            }
            //right
            for(int i = startrow+1; i<=endrow; i++){
                System.out.print(matrix[i][endcol]+" ");
            }
            //bottom
            for(int j=endcol-1;j>= startcol; j--){
                //this condition make sures that values are not printed twice.
                //helpful when no of boundaries are odd.
                if(startrow==endrow){
                    break;
                }
                System.out.print(matrix[endrow][j]+" ");
            }
            //left
            for(int i = endrow-1; i>= startrow+1;i--){
                if(startcol==endcol){
                    break;
                }
                System.out.print(matrix[i][startcol]+" ");
            }
            startcol++;
            startrow++;
            endrow--;
            endcol--;

        }
        System.out.println("Complete");
    }
    public static void main(String args[]){
        int matrix[][]={{1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}};
        printSpiral(matrix);

    }
    
}
