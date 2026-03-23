

import java.util.Queue;
import java.util.LinkedList;

public class NumberofIslandsJava {
    public int numIslands(char[][] grid) {
        int rows, cols, ans;
        rows = grid.length;
        if (0 == rows) return 0;
        cols = grid[0].length;
        ans = 0;
        boolean[][] visited = new boolean[rows][cols];
        // for (boolean[] arr : visited) {
        //     System.out.println(Arrays.toString(arr));
        // }
        int[][] dirs = new int[][]{
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]){
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int[] dir : dirs) {
                            int new_x, new_y;
                            new_x = cur[0] + dir[0];
                            new_y = cur[1] + dir[1];
                            if (new_x >= 0 &&
                                new_x < rows &&
                                new_y >= 0 &&
                                new_y < cols &&
                                !visited[new_x][new_y] &&
                                grid[new_x][new_y] == '1'){
                                q.offer(
                                    new int[]{
                                        new_x, new_y
                                    }
                                );
                                visited[new_x][new_y] = true;
                            }
                        }
                    }
                    ans++;
                }
            }    
        }
        return ans;
    }


    public static void main(String[] args) {
        NumberofIslandsJava test =
            new NumberofIslandsJava();
        System.out.println(test.numIslands(
            new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
            }
        ));
        System.out.println(test.numIslands(
            new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
            }
        ));
        System.out.println(test.numIslands(
            new char[][]{
                {'1'},
                {'1'}
            }
        ));
    }
}