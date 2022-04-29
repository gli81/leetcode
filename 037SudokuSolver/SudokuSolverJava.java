import java.util.Arrays;

public class SudokuSolverJava {
    public void solveSudoku(char[][] board){solveSudoku_(board);}

    public boolean solveSudoku_(char[][] board) {
        char[] nums = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int k = 0; k < nums.length; k++) {
                        board[i][j] = nums[k];
                        // System.out.println(i + ", " + j);
                        // showBoard(board);
                        // System.out.println(check(board, i, j));
                        // System.out.println();
                        if (check(board, i, j) && solveSudoku_(board)) return true;
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean check(char[][] board, int x, int y) {
        // check row and column
        for (int i = 0; i < 9; i++) {
            if (i != x && board[i][y] == board[x][y]) return false;
            if (i != y && board[x][i] == board[x][y]) return false;
        }
        // check square
        int m, n;
        m = x / 3;
        n = y / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if((3 * m + i != x || 3 * n + j != y) && board[x][y] == board[3 * m + i][3 * n + j]) return false;
            }
        }
        return true;
    }

    public void showBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public static void main(String[] args) {
        SudokuSolverJava test = new SudokuSolverJava();
        char[][] test1 = new char[][]{
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        test.solveSudoku(test1);
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(test1[i]));
        }
    }
}