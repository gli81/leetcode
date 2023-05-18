

import java.util.Arrays;

public class ThreeSumClosestJava {
    public static void main(String[] args) {
        ThreeSumClosestJava test = new ThreeSumClosestJava();
        System.out.println(
            test.threeSumClosest2(new int[]{-1,2,1,-4}, 1)
        );
        System.out.println(
            test.threeSumClosest2(new int[]{0, 0, 0}, 1)
        );
    }

    public int threeSumClosest2(int[] nums, int target) {
        int ans = 0, diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1, hi = nums.length - 1;
            while(lo < hi) {
                if (Math.abs(
                    nums[i] + nums[lo] + nums[hi] - target
                ) < diff) {
                    ans = nums[i] + nums[lo] + nums [hi];
                    diff = Math.abs(
                        nums[i] + nums[lo] + nums[hi] - target
                    );
                }
                if (diff == 0) return ans;
                if (nums[i] + nums[lo] + nums[hi] > target) {
                    hi--;
                } else if (
                    nums[i] + nums[lo] + nums[hi] < target
                ) {
                    lo++;
                }
            }
        }
        return ans;
    }
}