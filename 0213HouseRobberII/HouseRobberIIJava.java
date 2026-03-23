

public class HouseRobberIIJava {
    public int rob(int[] nums) {
        return Math.max(
            robHelper(nums, 0, nums.length - 1), 
            robHelper(nums, 1, nums.length)
        );
    }

    private int robHelper(int[] nums, int start, int end) {
        int len = end - start;
        if (len == -1) {
            return 0; // nums.length == 0
        }
        if (len == 0) {
            return nums[0]; // nums.length == 1
        }
        if (len == 1) {
            return nums[start]; // nums.length == 2
        }
        int[] dp = new int[len];
        dp[0] = nums[start];
        dp[1] = Math.max(dp[0], nums[start + 1]);
        for (int i = 2; i < len; ++i) {
            dp[i] = Math.max(
                dp[i - 1], dp[i - 2] + nums[start + i]
            );
        }
        return dp[len - 1];
    }
}
