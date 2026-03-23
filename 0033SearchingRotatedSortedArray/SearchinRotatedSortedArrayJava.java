

public class SearchinRotatedSortedArrayJava {
    public int search3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            // left sub-array is sorted
            if (nums[left] <= nums[mid]) {
                // target is in this sub-array
                if (nums[left] <= target && nums[mid] > target) right = mid - 1;
                else left = mid + 1;
            } else {
                // target is in this sub-array
                if (nums[mid] < target && nums[right] >= target) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
