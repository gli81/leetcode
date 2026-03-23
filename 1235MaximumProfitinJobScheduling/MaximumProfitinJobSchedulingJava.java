
import java.util.Arrays;

public class MaximumProfitinJobSchedulingJava {
    public int jobScheduling(
        int[] startTime,
        int[] endTime,
        int[] profit
    ) {
        int n = startTime.length;
        int[][] jobs = new int[n][];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        int[] dp = new int[n + 1];
        int k = 0;
        for (int i = 1; i < n + 1; i++) {
            k = binary_search(
                jobs,
                jobs[i - 1][0], // 当前job的start time
                i - 1
            );
            dp[i] = Math.max(
                dp[i - 1],
                dp[k] + jobs[i - 1][2]
            );
        }
        return dp[n];
    }

    private int binary_search(
        int[][] jobs,
        int target,
        int end
    ) {
        int l = 0;
        int mid;
        int r = end;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (jobs[mid][1] > target) r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }


    public static void main(String[] args) {
        MaximumProfitinJobSchedulingJava test = 
            new MaximumProfitinJobSchedulingJava();
        System.out.println(test.jobScheduling(
            new int[]{1, 2, 3, 3},
            new int[]{3, 4, 5, 6},
            new int[]{50, 10, 40, 70}
        ));
    }
}
