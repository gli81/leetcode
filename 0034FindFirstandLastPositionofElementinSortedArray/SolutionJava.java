import java.util.Arrays;

public class SolutionJava {
	public int[] searchRange(int[] nums, int target) {
		int[] ans = new int[]{-1, -1};
		if (nums.length == 0) return ans;
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] >= target) right = mid - 1;
			else left = mid + 1;
		}
		// left is pointing at the start of range
		if (left == nums.length || nums[left] != target) return ans;
		ans[0] = left;
		left = 0;
		right = nums.length - 1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] <= target) left = mid + 1;
			else right = mid - 1;
		}
		ans[1] = right;
		return ans;
	}

	public static void main(String[] args) {
		SolutionJava test = new SolutionJava();
		System.out.println(Arrays.toString(test.searchRange(new int[]{5,7,7,8,8,10}, 8)));
		System.out.println(Arrays.toString(test.searchRange(new int[]{5,7,7,8,8,10}, 6)));
		System.out.println(Arrays.toString(test.searchRange(new int[]{}, 0)));
	}
}