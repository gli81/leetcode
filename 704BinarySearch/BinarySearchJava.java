public class BinarySearchJava {
    public int search(int[] nums, int target) {
        int l, r;
        l = 0;
        r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }


    public static void main(String[] args) {
        BinarySearchJava test = new BinarySearchJava();
        System.out.println(
            test.search(
                new int[]{-1, 0, 3, 5, 9, 12},
                9
            )
        );
        System.out.println(
            test.search(
                new int[]{-1, 0, 3, 5, 9, 12},
                2
            )
        );
    }
}