
public class MaximumSubarrayJava {
    public static void main(String[] args) {
        MaximumSubarrayJava test = new MaximumSubarrayJava();
        System.out.println(test.maxSubArray2(
                new int[]{-2,1,-3,4,-1,2,1,-5,4})
            );
    }

    /*
     * over RAM limit :)
    */
    public int maxSubArray1(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++) {
            dp[j][0] = nums[j];
            if (dp[j][0] > ans) ans = dp[j][0];
            for (int i = 1; i < n - j; i++) {
                dp[j][i] = dp[j][i - 1] + nums[j + i];
                if (dp[j][i] > ans) ans = dp[j][i];
            }
        }
        return ans;
    }
    
    /*
     * over time limit :)
     */
    public int maxSubArray2(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int n = nums.length;
        int[] dp = new int[n];
        for (int j = 0; j < n; j++) {
            dp[0] = nums[j];
            if (dp[0] > ans) ans = dp[0];
            for (int i = 1; i < n - j; i++) {
                dp[i] = dp[i - 1] + nums[j + i];
                if (dp[i] > ans) ans = dp[i];
            }
        }
        return ans;
    }

    /*
     * AC
     */
    public int maxSubArray3(int[] nums) {
        int ans = nums[0];
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            // if (dp[i - 1] <= 0) dp[i] = nums[i];
            // else dp[i] = dp[i - 1] + nums[i];
            dp[i] = dp[i - 1] <= 0 ? nums[i] : dp[i - 1] + nums[i];
            if (ans < dp[i]) ans = dp[i];
        }
        return ans;
    }
}