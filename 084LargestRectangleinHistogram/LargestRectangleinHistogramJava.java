

import java.util.Arrays;
import java.util.HashSet;

public class LargestRectangleinHistogramJava {
    public int largestRectangleArea1(int[] heights) {
        /**
         * brute force solution
         * over time limit
         */
        HashSet<Integer> heights_set = new HashSet<>();
        for (int i = 0; i < heights.length; i++) {
            heights_set.add(heights[i]);
        }
        int max_area = 0;
        for (int h : heights_set) {
            int width = 0;
            int max_width = 1;
            for (int i = 0; i < heights.length; i++) {
                if (heights[i] >= h) {
                    width++;
                } else {
                    max_width = Math.max(width, max_width);
                    width = 0;
                }
            }
            max_width = Math.max(width, max_width);
            max_area = Math.max(max_area, h * max_width);
        }
        return max_area;
    }


    public int largestRectangleArea4(int[] heights) {
        /**
         * find index of first shorter hist 
         * to the left of heights[i] => left_first_shorter
         * 
         * and index of first shorter hist to the right of
         * heights[i] => right_first_shorter
         */
        int len_ = heights.length;
        int[] left_first_shorter = new int[len_];
        int[] right_first_shorter = new int[len_];
        for (int i = 0; i < len_; i++) {
            left_first_shorter[i] = i - 1;
            right_first_shorter[i] = i + 1;
        }
        // 
        for (int i = 1; i < len_; i++) {
            int l = i - 1;
            while (l >= 0 && heights[l] >= heights[i]) {
                l = left_first_shorter[l];
            }
            left_first_shorter[i] = l;
        }
        // System.out.println(Arrays.toString(left_first_shorter));
        for (int i = len_ - 2; i > -1; i--) {
            int r = i + 1;
            while (r < len_ && heights[r] >= heights[i]) {
                r = right_first_shorter[r];
            }
            right_first_shorter[i] = r;
        }
        // System.out.println(Arrays.toString(right_first_shorter));

        // get max area
        int max_area = 0;
        int area = 0;
        for (int i = 0; i < len_; i++) {
            area = heights[i] * (
                right_first_shorter[i] - left_first_shorter[i] - 1
            );
            max_area = Math.max(area, max_area);
        }
        return max_area;
    }
    
    public static void main(String[] args) {
        LargestRectangleinHistogramJava test =
            new LargestRectangleinHistogramJava();
        System.out.println(test.largestRectangleArea4(
            new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(test.largestRectangleArea4(
            new int[]{2, 4}));
    }
}
