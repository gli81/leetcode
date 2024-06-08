import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

public class SlidingWindowMaximumJava {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        // deal with first window
        for (int i = 0; i < k; ++i) {
            if (dq.isEmpty()) dq.add(i);
            else {
                while (
                    !dq.isEmpty() && 
                    nums[dq.peekLast()] < nums[i]
                ) {
                    dq.pollLast();
                }
                dq.add(i);
            }
        }
        // add first ans
        ans[0] = nums[dq.peekFirst()];
        int l = 1;
        for (int i = k; i < n; ++i) {
            while (
                !dq.isEmpty() && 
                nums[dq.peekLast()] < nums[i]
            ) {
                dq.pollLast();
            }
            dq.add(i);
            if (l > dq.peekFirst()) dq.pollFirst();
            ans[l++] = nums[dq.peekFirst()];
        }
        return ans;
    }
    public static void main(String[] args) {
        SlidingWindowMaximumJava test =
            new SlidingWindowMaximumJava();
        System.out.println(
            Arrays.toString(test.maxSlidingWindow(
                new int[]{1, 2, 1, 0, 4, 2, 6}, 3)
        ));
    }
}
