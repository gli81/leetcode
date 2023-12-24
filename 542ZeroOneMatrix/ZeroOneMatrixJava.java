import java.util.Arrays;

public class ZeroOneMatrixJava {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] ans = new int[rows][cols];
        // int[][] dirs = new int[][]{
        //     {-1, 0}, {1, 0},
        //     {0, 1}, {0, -1}
        // };
        // for (int i = 0; i < rows; i++)
        //     Arrays.fill(ans[i], Integer.MAX_VALUE / 2);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) ans[i][j] = 0;
                else ans[i][j] = Integer.MAX_VALUE / 2;
            }
        }
        // left and up
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i - 1 >= 0) {
                    ans[i][j] = Math.min(
                        ans[i][j], ans[i - 1][j] + 1
                    );
                }
                if (j - 1 >= 0) {
                    ans[i][j] = Math.min(
                        ans[i][j], ans[i][j - 1] + 1
                    );
                }
            }
        }
        // left down
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < cols; j++) {
                if (i + 1 < rows) {
                    ans[i][j] = Math.min(
                        ans[i][j], ans[i + 1][j] + 1
                        );
                    }
                if (j - 1 >= 0) {
                    ans[i][j] = Math.min(
                        ans[i][j], ans[i][j - 1] + 1
                    );
                }
            }
        }
        // right and up
        for (int i = 0; i < rows; i++) {
            for (int j = cols - 1; j >= 0; j--) {
                if (i - 1 >= 0) {
                    ans[i][j] = Math.min(
                        ans[i][j], ans[i - 1][j] + 1
                    );
                }
                if (j + 1 < cols) {
                    ans[i][j] = Math.min(
                        ans[i][j], ans[i][j + 1] + 1
                    );
                }
            }
        }
        // right down
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (i + 1 < rows) {
                    ans[i][j] = Math.min(
                        ans[i][j], ans[i + 1][j] + 1
                    );
                }
                if (j + 1 < cols) {
                    ans[i][j] = Math.min(
                        ans[i][j], ans[i][j + 1] + 1
                    );
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        ZeroOneMatrixJava test = 
            new ZeroOneMatrixJava();
        for (int[] row : test.updateMatrix(new int[][]{
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        })) System.out.println(Arrays.toString(row));
        for (int[] row : test.updateMatrix(new int[][]{
            {0, 0, 0},
            {0, 1, 0},
            {1, 1, 1}
        })) System.out.println(Arrays.toString(row));
    }
}
