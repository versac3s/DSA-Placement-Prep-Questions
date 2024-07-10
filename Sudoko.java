public class Sudoko {
    public static boolean isSafe(int board[][], int row, int col, int digit) {
        for (int i = 0; i <= 8; i++) {
            if (board[i][col] == digit) { // digit already present
                return false;
            }
        }
        for (int j = 0; j <= 8; j++) {
            if (board[row][j] == digit) {
                return false;
            }
        }
        int start_row = (row / 3) * 3;
        int start_col = (col / 3) * 3;
        for (int i = start_row; i < start_row + 3; i++) {
            for (int j = start_col; j < start_col + 3; j++) {
                if (board[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sudoko_solver(int board[][], int i, int j) {
        // base case
        if (i == 9) {
            return true;
        }
        // recursion
        int nextRow = i, nextCol = j + 1;
        if (j + 1 == 9) {
            nextRow = i + 1;
            nextCol = 0;
        }
        // if we already have an element placed, we have to skip that
        if (board[i][j] != 0) {
            return sudoko_solver(board, nextRow, nextCol);
        }

        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(board, i, j, digit)) {
                board[i][j] = digit;
                if (sudoko_solver(board, nextRow, nextCol)) {
                    return true;
                }
                board[i][j] = 0;
            }
        }
        return false;
    }

    public static void print(int board[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]) {
        int sudoko[][] = { { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
                { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
                { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
                { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
                { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
                { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
                { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
                { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
                { 8, 2, 7, 0, 0, 9, 0, 1, 3 } };
        if (sudoko_solver(sudoko, 0, 0)) {
            System.out.println("Solution exists");
            print(sudoko);
        } else {
            System.out.println("Solution does not exists");
        }
    }
}
