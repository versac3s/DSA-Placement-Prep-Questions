public class NQueens {

    public static void print(char board[][]) {
        System.out.println("-------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(char board[][], int row, int col) {
        // vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // diagonal left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // diagonal right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void nQueens(char board[][], int row) {
        // base case
        if (row == board.length) {
            print(board);
            count++;
            return;
        }
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row + 1);// function call
                board[row][j] = 'x';// backtrack step
            }
        }
    }

    // count no. of ways
    static int count = 0;

    // check if porblem can be solved and give only 1 possible solution
    // public static boolean nQueens(char board[][], int row) {
    //     // base case
    //     if (row == board.length) {
    //         print(board);
    //         count++;
    //         return true;
    //     }
    //     for (int j = 0; j < board.length; j++) {
    //         if (isSafe(board, row, j)) {
    //             board[row][j] = 'Q';
    //             if (nQueens(board, row + 1)) {
                    
    //                 return true;
    //             } // function call
    //             System.out.println("solution possible. ");
    //             board[row][j] = 'x';// backtrack step
    //         }  
    //     }
    //     return false;
    // }

    public static void main(String args[]) {
        int n = 4;
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'x';
            }
        }
        nQueens(board, 0);
        System.out.println("Total ways= " + count);
    }
}
// TIME COMPLEXITY =O(n!)
// recurrence relation = n*T(n-1) +isSafe()