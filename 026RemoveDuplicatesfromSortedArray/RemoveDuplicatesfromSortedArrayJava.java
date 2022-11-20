

public class RemoveDuplicatesfromSortedArrayJava {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 1;  // count
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i - 1]) {
                nums[i++] = nums[j];
            }
        }
        // System.out.println(Arrays.toString(nums));
        return i;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
    }
}