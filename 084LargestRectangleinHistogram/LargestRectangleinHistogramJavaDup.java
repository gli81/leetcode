

// import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class LargestRectangleinHistogramJavaDup {
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

    public int largestRectangleArea5(int[] heights) {
        /*
         * stack
         */
        Stack<Integer> stk = new Stack<>();
        int max_area = 0;
        for (int i = 0; i < heights.length; ++i) {
            // non empty
            while (
                !stk.isEmpty() && 
                heights[i] < heights[stk.peek()]
            ) {
                int ind = stk.pop();
                int h = heights[ind];
                int l = stk.isEmpty() ? -1 : stk.peek();
                max_area = Math.max(
                    max_area, (i - l - 1) * h
                );
            }
            stk.push(i);

        }
        // everything through the stack
        // if stack not empty
        // compute for these in the stack
        while (!stk.isEmpty()) {
            // pop current top, and record its height
            int h = heights[stk.pop()];
            int left = stk.isEmpty() ? -1 : stk.peek();
            // no shorter ones left in the array
            // if there were shorter one
            // it would pop everything taller than it
            // so right border is right most
            int area = h * (heights.length - left - 1);
            max_area = Math.max(max_area, area);
        }
        return max_area;
    }
    
    public static void main(String[] args) {
        LargestRectangleinHistogramJavaDup test =
            new LargestRectangleinHistogramJavaDup();
        System.out.println(test.largestRectangleArea5(
            new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(test.largestRectangleArea5(
            new int[]{2, 4}));
        System.out.println(test.largestRectangleArea5(
            new int[]{2, 3, 1}));
    }
}
