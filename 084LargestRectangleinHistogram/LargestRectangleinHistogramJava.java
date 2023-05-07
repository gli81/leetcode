

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


    public int largestRectangleArea2(int[] heights) {
        return 0;
    }
    
    public static void main(String[] args) {
        LargestRectangleinHistogramJava test =
            new LargestRectangleinHistogramJava();
        System.out.println(test.largestRectangleArea1(
            new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(test.largestRectangleArea1(
            new int[]{2, 4}));
    }
}
