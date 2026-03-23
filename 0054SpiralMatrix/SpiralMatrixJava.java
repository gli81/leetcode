
import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixJava {
    public static void main(String[] args) {
        SpiralMatrixJava test = new SpiralMatrixJava();
        System.out.println(
            test.spiralOrder(new int[][] {{1, 2, 3},
                                        {4, 5, 6},
                                        {7, 8, 9}
                                    })
        );
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length;
        if (n == 0) return ans;
        // check if empty matrix first, then set m
        int m = matrix[0].length;

        char current_dir = 'r';
        int x = 0;
        int y = 0;
        int right_border = m;
        int down_border = n;
        int left_border = -1;
        int top_border = -1; // -1 not 0

        while (true) {
            // if every element is in the ans list, return
            if (ans.size() == m * n) return ans;
            ans.add(matrix[y][x]);
            switch (current_dir) {
                case 'r':
                    if (x + 1 == right_border) {
                        current_dir = 'd';
                        y += 1;
                        // top border move down
                        // bc top line finished
                        top_border += 1;
                    } else {
                        x += 1;
                    }
                    break;
                case 'd':
                    if (y + 1 == down_border) {
                        current_dir = 'l';
                        x -= 1;
                        right_border -= 1;
                    } else {
                        y += 1;
                    }
                    break;
                case 'l':
                    if (x - 1 == left_border) {
                        current_dir = 'u';
                        y -= 1;
                        down_border -= 1;
                    } else {
                        x -= 1;
                    }
                    break;
                case 'u':
                    if (y - 1 == top_border) {
                        current_dir = 'r';
                        x += 1;
                        left_border += 1;
                    } else {
                        y -= 1;
                    }
            }
            // System.out.println(ans);
        }
    }
}