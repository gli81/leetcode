

import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

public class RottingOrangesJava {
    public int orangesRotting(int[][] grid) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int rows = grid.length;
        if (0 == rows) return -1;
        int cols = grid[0].length;
        Queue<Integer> q = new LinkedList<>();
        int cnt = 0; // count for fresh orange
        Map<Integer, Integer> steps = new HashMap<>();
        for(int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    int ind = r * cols + c;
                    q.offer(ind);
                    steps.put(ind, 0);
                } else if (grid[r][c] == 1) {
                    cnt++;
                }
            }
        }
        int ans = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            int r = cur / cols;
            int c = cur % cols;
            for (int i = 0; i < 4; i++) {
                int new_r = r + dr[i];
                int new_c = c + dc[i];
                if (new_r >= 0 &&
                    new_r < rows &&
                    new_c >= 0 &&
                    new_c < cols &&
                    grid[new_r][new_c] == 1
                    ) {
                        cnt--;
                        grid[new_r][new_c] = 2;
                        int new_code = 
                            new_r * cols + new_c;
                        q.offer(new_code);
                        steps.put(
                            new_code,
                            steps.get(cur) + 1
                        );
                        ans = Math.max(
                            ans, steps.get(new_code)
                        );
                }
            }
        }
        return cnt == 0 ? ans : -1;
    }


    public static void main(String[] args) {
        RottingOrangesJava test = 
            new RottingOrangesJava();
        System.out.println(test.orangesRotting(
            new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
            }
        ));
    }
}
