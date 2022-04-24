

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class FourSumJava {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        int lo = j + 1, hi = nums.length - 1, looking = target - nums[i] - nums[j];
                        while (lo < hi) {
                            if (nums[lo] + nums[hi] == looking) {
                                ans.add(Arrays.asList(new Integer[]{nums[i], nums[j], nums[lo], nums[hi]}));
                                while (lo < hi && nums[lo] == nums[lo + 1]) {lo++;}
                                while (lo < hi && nums[hi] == nums[hi - 1]) {hi--;}
                                lo++;
                                hi--;
                            }
                            else if (nums[lo] + nums[hi] < looking) {
                                lo++;
                            } else {
                                hi--;
                            }
                    }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new FourSumJava().fourSum(new int[]{1,0,-1,0,-2,2}, 0));
        System.out.println(new FourSumJava().fourSum(new int[]{2,2,2,2,2}, 8));
        System.out.println(new FourSumJava().fourSum(new int[]{-2,-1,-1,1,1,2,2}, 0));
    }
}