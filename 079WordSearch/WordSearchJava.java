

public class WordSearchJava {
    public boolean exist(char[][] board, String word) {
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
