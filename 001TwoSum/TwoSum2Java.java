import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class TwoSum2Java {
    public int[] twoSum(int[] nums, int target) {
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
        int[] nums = new int[]{3, 2, 4};
        int target = 6;
        
        TwoSum2Java obj = new TwoSum2Java();
        System.out.println(Arrays.toString(
            obj.twoSum(nums, target)));
    }
}
