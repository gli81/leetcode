

public class WordSearchJava {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        if (rows == 0) return false;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (exist_(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist_(char[][] board, int row, int col,
                            String word, int index,
                            boolean[][] visited) {
        // out of board
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return false;
        }
        // visited
        // not what we are looking for
        if (visited[row][col] ||
            board[row][col] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) return true;
        visited[row][col] = true;
        // try four directions
        // up
        if (exist_(board, row - 1, col,
                    word, index + 1, visited)) return true;
        // down
        if (exist_(board, row + 1, col,
                    word, index + 1, visited)) return true;
        // left
        if (exist_(board, row, col - 1,
                    word, index + 1, visited)) return true;
        // right
        if (exist_(board, row, col + 1,
                    word, index + 1, visited)) return true;
        // no next letter
        visited[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        WordSearchJava test = new WordSearchJava();
        System.out.println(test.exist(new char[][]{
            new char[]{'A', 'B', 'C', 'E'},
            new char[]{'S', 'F', 'C', 'S'},
            new char[]{'A', 'D', 'E', 'E'}
        }, "ABCCED"));
        System.out.println(test.exist(new char[][]{
            new char[]{'A', 'B', 'C', 'E'},
            new char[]{'S', 'F', 'C', 'S'},
            new char[]{'A', 'D', 'E', 'E'}
        }, "SEE"));
        System.out.println(test.exist(new char[][]{
            new char[]{'A', 'B', 'C', 'E'},
            new char[]{'S', 'F', 'C', 'S'},
            new char[]{'A', 'D', 'E', 'E'}
        }, "ABCB"));
    }
}
