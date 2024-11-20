

public class SortanArrayJava {
    public int[] sortArray2(int[] nums) {
        // merge sort
        mergeSort(nums, 0, nums.length);
        return nums;
    }

    private void mergeSort(int[] nums, int l, int r) {
        int len = r - l;
        if (len <= 1) return;
        int mid = (len) / 2 + l;
        mergeSort(nums, l,  mid);
        mergeSort(nums, mid, r);
        int[] tmp = new int[len];
        int i = l, j = mid;
        int ct = 0;
        while (i < mid && j < r) {
            if (nums[i] <= nums[j]) {
                tmp[ct++] = nums[i++];
            } else {
                tmp[ct++] = nums[j++];
            }
        }
        while (i < mid) {
            tmp[ct++] = nums[i++];
        }
        while (j < r) {
            tmp[ct++] = nums[j++];
        }
        for (int k = 0; k < len; ++k) {
            nums[k + l] = tmp[k];
        }
    }
}