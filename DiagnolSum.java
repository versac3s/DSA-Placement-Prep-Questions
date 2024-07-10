public class DiagnolSum {
    public static void Sum(int matrix[][]) {
        int sum = 0;
        //for (int i = 0; i <= matrix.length; i++) {
            //for (int j = 0; j <= matrix[0].lenght; j++) {
                //if (i == j) {
                    //sum += matrix[i][j]; // we got the sum of primary diagnol
                //} else if (i + j == matrix.length - 1) {
                    //sum += matrix[i][j];
                //}
            //}
        //}
        //return sum;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
            if (i != matrix.length - 1 - i) {
                sum += matrix[i][matrix.length - i - 1];
            }
        }
        System.out.print(sum);
    }

    public static void main(String args[]) {
        int matrix[][] = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        Sum(matrix);
    }

}
