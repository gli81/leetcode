

import java.util.HashMap;

public class MajorityElementJava {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(
                nums[i],
                map.getOrDefault(
                    nums[i], 0
                ) + 1
            );
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        MajorityElementJava test =
            new MajorityElementJava();
        System.out.println(
            test.majorityElement(new int[]{3, 2, 3})
        );
    }
}
