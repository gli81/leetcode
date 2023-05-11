

public class MaximalRectangleJava {
    public int maximalRectangle(char[][] matrix) {
        int[] heights = new int[matrix[0].length];
        int max_area = 0;
        // update heights
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') heights[j]++;
                else heights[j] = 0;
            }
            max_area = Math.max(
                max_area, largestRectangleinHistogram4(heights)
            );
        }
        return max_area;
    }

    private int largestRectangleinHistogram4(int[] heights) {
        int len_ = heights.length;
        int[] left_first_shorter = new int[len_];
        int[] right_first_shorter = new int[len_];
        for (int i = 0; i < len_; i++) {
            left_first_shorter[i] = i - 1;
            right_first_shorter[i] = i + 1;
        }
        // update left
        for (int i = 1; i < len_; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]) {
                p = left_first_shorter[p];
            }
            left_first_shorter[i] = p;
        }
        // update right
        for (int i = len_ - 2; i > -1; i--) {
            int p = i + 1;
            while (p < len_ && heights[p] >= heights[i]) {
                p = right_first_shorter[p];
            }
            right_first_shorter[i] = p;
        }
        int max_area = 0;
        for (int i = 0; i < len_; i++) {
            int area = 
                (right_first_shorter[i] - left_first_shorter[i] - 1) * heights[i];
            max_area = Math.max(max_area, area);
        }
        return max_area;
    }

    public static void main(String[] args) {
        MaximalRectangleJava test =
            new MaximalRectangleJava();
        System.out.println(test.maximalRectangle(
            new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
            }));
        System.out.println(test.maximalRectangle(
            new char[][]{{'0'}}
        ));
        System.out.println(test.maximalRectangle(
            new char[][]{{'1'}}
        ));
    }
}
