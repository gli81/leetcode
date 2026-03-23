

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumJava {
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        // put everything in the map
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        // traverse the array
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (map.containsKey(sub) && i != map.get(sub)) {
                ans[0] = i;
                ans[1] = map.get(sub);
                return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{11, 15, 2, 7};
        int target = 9;
        
        TwoSumJava obj = new TwoSumJava();
        System.out.println(
            Arrays.toString(obj.twoSum1(nums, target))
        );

        nums = new int[]{3, 2, 4};
        target = 6;
        System.out.println(
            Arrays.toString(obj.twoSum2(nums, target))
        );
    }
}
