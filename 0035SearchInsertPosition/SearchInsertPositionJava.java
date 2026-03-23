

public class SearchInsertPositionJava {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return right + 1;
    }

    public static void main(String[] args) {
        SearchInsertPositionJava test = new SearchInsertPositionJava();
        int[] test1 = new int[]{1, 3, 5, 6};
        System.out.println(test.searchInsert(test1, 5));
        System.out.println(test.searchInsert(test1, 2));
        System.out.println(test.searchInsert(test1, 7));
        System.out.println(test.searchInsert(test1, 0));
        System.out.println(test.searchInsert(new int[]{1}, 0));
    }
}
