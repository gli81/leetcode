

public class SearchinRotatedSortedArrayIIJava {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (target == nums[mid]) return true;
            if (nums[start] < nums[mid]) {
                // left half sorted
                // check whether the target is here
                if (target >= nums[start] && target < nums[mid]) {
                    // if target in left half
                    // focus on left only
                    end = mid - 1;
                } else {
                    // if target not in left half
                    // target in the unsorted right half
                    // focus on the right half
                    start = mid + 1;
                }
            } else if (nums[start] == nums[mid]) {
                start++;
            } else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchinRotatedSortedArrayIIJava test = 
            new SearchinRotatedSortedArrayIIJava();
        System.out.println(test.search(new int[]{
            2,5,6,0,0,1,2
        }, 0));
        System.out.println(test.search(new int[]{
            2,5,6,0,0,1,2
        }, 3));
        System.out.println(test.search(new int[]{
            5, 1, 3
        }, 3));
    }
}