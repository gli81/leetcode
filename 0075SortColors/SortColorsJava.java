

import java.util.Arrays;

public class SortColorsJava {
    public void sortColors1(int[] nums) {
        int zero_ct = 0;
        int one_ct = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zero_ct++;
            if (nums[i] == 1) one_ct++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (zero_ct > 0) {
                nums[i] = 0;
                zero_ct--;
            } else if (one_ct > 0) {
                nums[i] = 1;
                one_ct--;
            } else nums[i] = 2;
        }
    }

    public void sortColors2(int[] nums) {
        int zero_pos = 0;
        int two_pos = nums.length - 1;
        for (int i = 0; i <= two_pos; i++) {
            int temp;
            if (nums[i] == 0) {
                temp = nums[zero_pos];
                nums[zero_pos] = 0;
                nums[i] = temp;
                zero_pos++;
            } else if (nums[i] == 2) {
                temp = nums[two_pos];
                nums[two_pos] = 2;
                nums[i] = temp;
                two_pos--;
                i--;
            }
        }
    }

    public static void main(String[] args) {
        SortColorsJava test = new SortColorsJava();
        int[] test1 = new int[]{2, 0, 2, 1, 1, 0};
        int[] test2 = new int[]{2, 0, 1};
        test.sortColors2(test1);
        test.sortColors2(test2);
        System.out.println(Arrays.toString(test1));
        System.out.println(Arrays.toString(test2));
    }
}