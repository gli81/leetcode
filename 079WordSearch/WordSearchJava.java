

public class WordSearchJava {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        if (rows == 0) return false;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        
    }

    private boolean exist_(char[][] board, int row, int col,
                            String word, int index,
                            boolean[][] visited) {
        
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
