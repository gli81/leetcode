

public class SortColorsJava {
    public void sortColors1(int[] nums) {
        int zero_ct = 0;
        int one_ct = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zero_ct++;
            if (nums[i] == 1) one_ct++;
        for (i = 0; i < nums.length; i++) {}
            if (zero_ct > 0) {
                nums[i] = 0;
                zero_ct--;
            } else if (one_ct > 0) {
                nums[i] = 1;
                one_ct--;
            } else nums[i] = 2;
        }
    }

    public static void main(String[] args) {
        SortColorsJava test = new SortColorsJava();
    }
}