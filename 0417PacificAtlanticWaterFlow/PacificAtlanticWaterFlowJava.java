

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class PacificAtlanticWaterFlowJava {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int m, n;
        m = heights.length;
        if (m == 0) return ans;
        n = heights[0].length;
        if (n == 0) return ans;
        boolean[][] atl = new boolean[m][n];
        boolean[][] pac = new boolean[m][n];
        // initialize queues
        Queue<int[]> aq = new LinkedList<>();
        Queue<int[]> pq = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            aq.offer(new int[]{i, n-1});
            pq.offer(new int[]{i, 0});
        }
        for (int j = 0; j < n; ++j) {
            aq.offer(new int[]{m-1, j});
            pq.offer(new int[]{0, j});
        }
        int[][] dirs = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };
        while (!aq.isEmpty()) {
            int[] cur = aq.poll();
            atl[cur[0]][cur[1]] = true;
            for (int[] d : dirs) {
                int newx = cur[0] + d[0];
                int newy = cur[1] + d[1];
                if (
                    newx >= 0 && newx < m
                    && newy >= 0 && newy < n
                    && !atl[newx][newy]
                    && heights[newx][newy] >= heights[cur[0]][cur[1]]
                ) {
                    aq.offer(new int[]{newx, newy});
                }
            }
        }
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            pac[cur[0]][cur[1]] = true;
            for (int[] d : dirs) {
                int newx = cur[0] + d[0];
                int newy = cur[1] + d[1];
                if (
                    newx >= 0 && newx < m
                    && newy >= 0 && newy < n
                    && !pac[newx][newy]
                    && heights[newx][newy] >= heights[cur[0]][cur[1]]
                ) {
                    pq.offer(new int[]{newx, newy});
                }
            }
        }
        // for (int i = 0; i < m; ++i) {
        //     for (int j = 0; j < n; ++j) {
        //         System.out.print(atl[i][j]);
        //         if (j != n - 1) {
        //             System.out.print(", ");
        //         }
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        // for (int i = 0; i < m; ++i) {
        //     for (int j = 0; j < n; ++j) {
        //         System.out.print(pac[i][j]);
        //         if (j != n - 1) {
        //             System.out.print(", ");
        //         }
        //     }
        //     System.out.println();
        // }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (atl[i][j] && pac[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        PacificAtlanticWaterFlowJava test = new PacificAtlanticWaterFlowJava();
        System.out.println(test.pacificAtlantic(
            new int[][] {
                {4, 2, 7, 3, 4},
                {7, 4, 6, 4, 7},
                {6, 3, 5, 3, 6}
            }
        ));
    }
}