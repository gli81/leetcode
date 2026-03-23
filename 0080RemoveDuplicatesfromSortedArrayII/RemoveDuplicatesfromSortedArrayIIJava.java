

public class RemoveDuplicatesfromSortedArrayIIJava {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;
        int ct = 1;
        while (fast < nums.length) {
            if (nums[slow] == nums[fast]) {
                if (ct == 1) {
                    ct++;
                    nums[++slow] = nums[fast];
                }
            } else {
                ct = 1;
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return ++slow;
    }

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArrayIIJava test = 
        new RemoveDuplicatesfromSortedArrayIIJava();
        System.out.println(test.removeDuplicates(
            new int[]{1, 1, 1, 2, 2, 3}
        ));
        System.out.println(test.removeDuplicates(
            new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}
        ));
    }
}
