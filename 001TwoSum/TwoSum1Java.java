
import java.util.Arrays;

public class TwoSum1Java {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{11, 15, 2, 7};
        int target = 9;
        
        TwoSum1Java obj = new TwoSum1Java();
        System.out.println(Arrays.toString(obj.twoSum(nums, target)));
    }
}
