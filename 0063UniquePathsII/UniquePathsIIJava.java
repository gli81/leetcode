

import java.util.HashMap;
import java.util.Map;

public class UniquePathsIIJava {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        int m, n;
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        Map<String, Integer> visited = new HashMap<>();
        return get_ans(0, 0, m - 1, n - 1,
                        visited, obstacleGrid);
    }

    private int get_ans(int x, int y, int m, int n,
                        Map<String, Integer> visited,
                        int[][] obstacleGrid) {
        if (x == m && y == n) return 1;
        int n1, n2;
        n1 = n2 = 0;
        // right
        String key = x + 1 + "@" + y;
        if (!visited.containsKey(key)) {
            if (x + 1 <= m && obstacleGrid[x + 1][y] == 0) {
                n1 = get_ans(x + 1, y, m, n,
                            visited, obstacleGrid);
            }
        } else n1 = visited.get(key);
        // down
        key = x + "@" + (y + 1);
        if (!visited.containsKey(key)) {
            if (y + 1 <= n && obstacleGrid[x][y + 1] == 0) {
                n2 = get_ans(x, y + 1, m, n,
                            visited, obstacleGrid);
            }
        } else n2 = visited.get(key);
        // put
        key = x + "@" + y;
        visited.put(key, n1 + n2);
        return n1 + n2;
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