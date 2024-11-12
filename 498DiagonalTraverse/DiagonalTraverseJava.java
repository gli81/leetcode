

public class DiagonalTraverseJava {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m * n];
        int ct = 0;
        for (int i = 0; i < m + n - 1; ++i) {
            int min_, x, y;
            if (i % 2 == 0) {
                min_ = Math.min(i, m-i);
                x = min_;
                y = i - min_;
                while (x >= 0 && y < n) {
                    ans[ct++] = mat[x--][y++];
                }
            } else {
                min_ = Math.min(i, n-i);
                x = i - min_;
                y = min_;
                while (x < m && y >= 0) {
                    ans[ct++] = mat[x++][y--];
                }
            }
        }
        return ans; 
    }
}