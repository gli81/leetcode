

public class TargetSumJava {
    private int ans = 0;


    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return this.ans;
    }

    private void backtrack(int[] nums, int target, int i, int sum) {
        if (i == nums.length) {
            if (sum == target) {
                ans++;
            }
        } else {
            backtrack(nums, target, i + 1, sum + nums[i]);
            backtrack(nums, target, i + 1, sum - nums[i]);
        }
    }
}