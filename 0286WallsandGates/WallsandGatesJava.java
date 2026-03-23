

import java.util.Queue;
import java.util.LinkedList;

public class WallsandGatesJava {
    public void wallsandGates(int[][] grid) {
        int m, n;
        m = grid.length;
        if (m == 0) return;
        n = grid[0].length;
        if (n == 0) return;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == -1) {
                    // wall
                    visited[i][j] = true;
                } else if (grid[i][j] == 0) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int[][] dirs = {
            {1, 0}, {-1, 0},
            {0, 1}, {0, -1}
        };
        int level = 0;
        while (!q.isEmpty()) {
            int cur_level = q.size();
            ++level;
            for (int i = 0; i < cur_level; ++i) {
                int[] cur = q.poll();
                int curx, cury;
                curx = cur[0]; cury = cur[1];
                for (int[] dir : dirs) {
                    int newx = dir[0] + curx;
                    int newy = dir[1] + cury;
                    if (
                        newx >= 0 && newx < m
                        && newy >= 0 && newy < n
                        && !visited[newx][newy]
                    ) {
                        grid[newx][newy] = level;
                        visited[newx][newy] = true;
                        q.offer(new int[]{newx, newy});
                    }
                }
            }
        }
    }
}
