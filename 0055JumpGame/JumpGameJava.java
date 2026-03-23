

import java.lang.Math;

public class JumpGameJava{
    public boolean canJump1(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > end) return false;
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) end = maxPosition;
        }
        return maxPosition >= nums.length - 1;
    }


    public static void main(String[] args) {
        JumpGameJava test = new JumpGameJava();
        System.out.println(
            test.canJump1(new int[]{2, 3, 1, 1, 4})
        );
        System.out.println(
            test.canJump1(new int[]{3, 2, 1, 0, 4})
        );
    }
}
