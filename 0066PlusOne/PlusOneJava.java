

import java.util.Arrays;

public class PlusOneJava{
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i > -1; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                return digits;
            } else digits[i] = 0;
        }
        if (digits[0] == 0) {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            // 0 at start, the rest all 0
            // for (int i = 0; i < digits.length; i++) {
            //     ans[i + 1] = digits[i]
            // }
            return ans;
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        PlusOneJava test = new PlusOneJava();
        System.out.println(
            Arrays.toString(test.plusOne(new int[]{1, 2, 3}))
        );
        System.out.println(
            Arrays.toString(test.plusOne(new int[]{4, 3, 2, 1}))
        );
        System.out.println(
            Arrays.toString(test.plusOne(new int[]{9}))
        );
    }
}