

import java.util.Set;
import java.util.HashSet;

public class FindtheDuplicateNumberJava {
    public int findDuplicate2(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            if (s.contains(num)) return num;
            else s.add(num);
        }
        return -1;
    }

    public int findDuplicate5(int[] nums) {
        int slow, fast;
        slow = fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int slow2 = 0;
        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }
        return slow;
    }


    public static void main(String[] args) {
        
    }
}
