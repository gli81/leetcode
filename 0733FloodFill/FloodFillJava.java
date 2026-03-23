import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class FloodFillJava {
    public int[][] floodFill(
        int[][] image,
        int sr,
        int sc,
        int color
    ) {
        int to_change = image[sr][sc];
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int rows = image.length;
        int cols = image[0].length;
        int [][] visited = new int[rows][cols];
        // for (int[] row : visited) System.out.println(Arrays.toString(row));
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        visited[sr][sc] = 1;
        while (q.size() > 0) {
            int[] cur = q.poll();
            image[cur[0]][cur[1]] = color;
            for (int[] dir : dirs) {
                int[] new_ = new int[]{
                    cur[0] + dir[0],
                    cur[1] + dir[1]
                };
                if (
                    new_[0] >= 0 &&
                    new_[0] < rows &&
                    new_[1] >= 0 &&
                    new_[1] < cols &&
                    visited[new_[0]][new_[1]] == 0 &&
                    image[new_[0]][new_[1]] == to_change
                ) {
                    q.offer(new_.clone());
                    visited[new_[0]][new_[1]] = 1;
                }
            }
        }
        return image;
    }


    public static void main(String[] args) {
        FloodFillJava test = new FloodFillJava();
        for (int[] row : test.floodFill(new int[][]{
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        }, 1, 1, 2)) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("=======================");
    }
}
