import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPermutationJava {
    public void nextPermutation(int[] nums) {
        // going from right to left, looking for the first not being descending
        int right = nums.length - 2;
        if (right == -1) return;
        while(right >= 0) {
            if (nums[right] < nums[right + 1]) {
                break;
            }
            right--;
        }
        // right being the index of element that is going to be swapped

        // whole array in descending order
        // TODO reverse the array and return
        if (right == -1) {
            reverse(nums, 0);
            return;
        }

        // TODO looking for swap
        int j;
        for (j = nums.length - 1; j > 0; j--) {
            if (nums[j] > nums[right]) {
                break;
            }
        }
        // TODO swap nums[right] and nums[j]
        swap(nums, right, j);
        // TODO reverse the following subarray
        reverse(nums, right + 1);
        return;

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int left) {
        int i = left, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        int[] test1 = new int[] {1, 2, 3};
        NextPermutationJava test = new NextPermutationJava();
        test.nextPermutation(test1);
        System.out.println(Arrays.toString(test1));
        System.out.println("===================================");
        int[] test2 = new int[] {3, 2, 1};
        test.nextPermutation(test2);
        System.out.println(Arrays.toString(test2));
        System.out.println("===================================");
        int[] test3 = new int[] {1, 1, 5};
        test.nextPermutation(test3);
        System.out.println(Arrays.toString(test3));
        System.out.println("===================================");
        int[] test4 = new int[] {1};
        test.nextPermutation(test4);
        System.out.println(Arrays.toString(test4));
        System.out.println("===================================");
    }
}
