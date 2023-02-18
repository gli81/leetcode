
public class MaximumSubarrayJava {
    public static void main(String[] args) {
        MaximumSubarrayJava test = new MaximumSubarrayJava();
        System.out.println(test.maxSubArray(
                new int[]{-2,1,-3,4,-1,2,1,-5,4})
            );
    }

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = Integer.MIN_VALUE;
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                dp[i] = dp[i] + nums[i + len - 1];
                if (dp[i] < max) {
                    max = dp[i];
                }
            }
        }
        return max;
    }
}