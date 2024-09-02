

public class BurstBalloonsJava {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] nums_ = new int[n + 2];
        nums_[0] = 1;
        nums_[n + 1] = 1;
        for (int i = 1; i < n + 1; ++i) {
            nums_[i] = nums[i - 1];
        }
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n - 1; i > -1; --i) {
            for (int j = i + 2; j < n + 2; ++j) {
                for (int k = i + 1; k < j; ++k) {
                    dp[i][j] = Math.max(
                        dp[i][j],
                        nums_[i] * nums_[k] * nums_[j] + dp[i][k] + dp[k][j]
                    );
                }
            }
        }
        // for (int i = 0; i < dp.length; ++i) {
        //     for (int j = 0; j < dp.length; ++j) {
        //         System.out.print(dp[i][j] + "\t");
        //     }
        //     System.out.print("\n");
        // }
        return dp[0][n + 2 - 1];
    }


    public static void main(String[] args) {
        BurstBalloonsJava test = new BurstBalloonsJava();
        System.out.println(
            test.maxCoins(new int[]{3, 1, 5, 8})
        );
    }
}