
public class UniquePathsIIJava {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m, n;
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;

        return 0;
    }

    private int get_ans(int x, int y, int m, int n,
                        Map<String, Integer> visited) {
        return 0 + get_ans();
    }

    public static void main(String[] args) {
        int[][] test1 = new int[][]{{0, 0, 0},
                                    {0, 1, 0},
                                    {0, 0, 0}};
        int[][] test2 = new int[][]{{0, 1},
                                    {0, 0}};
        UniquePathsIIJava test = new UniquePathsIIJava();
        System.out.println(
            test.uniquePathsWithObstacles(test1)
        );
        System.out.println(
            test.uniquePathsWithObstacles(test2)
        ); 
    }
}