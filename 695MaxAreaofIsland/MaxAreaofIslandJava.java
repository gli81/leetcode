

import java.util.Queue;
import java.util.LinkedList;

public class MaxAreaofIslandJava {
    public int maxAreaofIsland(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = new int[][]{
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                    int area = 1;
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int k = 0; k < 4; ++k) {
                            int nx = cur[0] + dirs[k][0];
                            int ny = cur[1] + dirs[k][1];
                            if (
                                nx >= 0 && nx < m && ny >= 0 && ny < n &&
                                !visited[nx][ny] && grid[nx][ny] == 1
                            ) {
                                area++;
                                visited[nx][ny] = true;
                                q.offer(new int[]{nx, ny});
                            }
                        }
                    }
                    ans = Math.max(ans, area);
                }
            }
        }
        return ans;
    }
}
