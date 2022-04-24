

import java.util.HashMap;

public class ValidSudokuJava {
    public static void main(String[] args) {
        ValidSudokuJava test = new ValidSudokuJava();
        char[][] board1 = new char[9][9];
        System.out.println(test.validSudoKu1(board1));
    }

    public boolean validSudoKu1(char[][] board) {
        // TODO check each row
        for (int i = 0; i < 9; i++) {
            if (!validRow(i, board)) return false;
        }

        // TODO check each column
        for (int i = 0; i < 9; i++) {
            if (!validCol(i, board)) return false;
        }

        // TODO check each sub-board
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!validSub(i, j, board)) return false;
            }
        }

        // TODO passed every test, return true
        return true;
    }

    private boolean validRow(int rowNum, char[][] board) {
        HashMap<Character, Integer> rowMap = new HashMap<Character, Integer>();
        for (int i = 0; i < 9; i++) {
            char current = board[rowNum][i];
            if (current != '.') {
                if (rowMap.containsKey(current)) return false;
                else rowMap.put(current, 1);
            }
        }
        return true;
    }

    private boolean validCol(int colNum, char[][] board) {
        HashMap<Character, Integer> colMap = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            char current = board[i][colNum];
            if (current != '.') {
                if (colMap.containsKey(current)) return false;
                else colMap.put(current, 1);
            }
        }
        return true;
    }

    private boolean validSub(int rowNum, int colNum, char[][] board) {
        HashMap<Character, Integer> subMap = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char current = board[rowNum + i][colNum + j];
                if (current != '.') {
                    if (subMap.containsKey(current)) return false;
                    else subMap.put(current, 1);
                }
            }
        }
        return true;
    }
}