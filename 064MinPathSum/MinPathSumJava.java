

public class MinPathSumJava {
    public int minPathSum(int[][] grid) {
        return null;
    }

    public static void main(String[] args) {
        MinPathSumJava test = new MinPathSumJava();
        System.out.println(test.minPathSum(new int[][]{
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        }));
        System.out.println(test.minPathSum(new int[][]{
            {1, 2, 3},
            {4, 5, 6}
        }));
    }
}