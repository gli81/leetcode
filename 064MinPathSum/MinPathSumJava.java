

import java.util.HashMap;

public class MinPathSumJava {
    public int minPathSum(int[][] grid) {
        int m, n;
        m = grid.length;
        n = grid[0].length;
        HashMap<String, Integer> visited = new HashMap<>();
        return get_ans(0, 0, m - 1, n - 1, visited, grid);
    }

    private int get_ans(int x, int y, int m, int n,
                        HashMap<String, Integer> visited,
                        int[][] grid) {
        if (x == m && y == n) return grid[m][n];
        // right
        String k = x + 1 + "@" + y;
        int n1, n2;
        // n1 = n2 = 0;
        /* 
         * if zero, when reach boundary
         * boundary side will be zero
        */
        n1 = n2 = Integer.MAX_VALUE;
        if (!visited.containsKey(k)) {
            if (x + 1 <= m){
                n1 = get_ans(x + 1, y, m, n, visited, grid);
            }
        } else {
            n1 = visited.get(k);
        }
        // down
        k = x + "@" + (y + 1);
        if (!visited.containsKey(k)) {
            if (y + 1 <= n) {
                n2 = get_ans(x, y + 1, m, n, visited, grid);
            }
        } else {
            n2 = visited.get(k);
        }

        // put current minimum steps in visted
        k = x + "@" + y;
        visited.put(k, Math.min(n1, n2) + grid[x][y]);
        return Math.min(n1, n2) + grid[x][y];
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