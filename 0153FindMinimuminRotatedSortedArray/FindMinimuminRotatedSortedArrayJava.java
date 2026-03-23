

public class FindMinimuminRotatedSortedArrayJava {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) r = mid;
            else l = mid + 1;
        }
        return nums[l];
    }


    public static void main(String[] args) {
        FindMinimuminRotatedSortedArrayJava test =
            new FindMinimuminRotatedSortedArrayJava();
        System.out.println(test.findMin(new int[]{
            3, 4, 5, 1, 2
        }));
        System.out.println(test.findMin(new int[]{
            4, 5, 6, 7, 0, 1, 2
        }));
        System.out.println(test.findMin(new int[]{
            11, 13, 15, 17
        }));
    }
}
