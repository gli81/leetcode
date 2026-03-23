

#include <vector>

class SortanArray {
public:
    std::vector<int> sortArray2(std::vector<int>& nums) {
        mergeSort(nums, 0, nums.size());
        return nums;
    }

private:
    void mergeSort(
        std::vector<int>& nums, size_t start, size_t end
    ) {
        size_t len = end - start;
        if (len <= 1) return;
        size_t mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid, end);
        size_t i = start, j = mid, ct = 0;
        int tmp[len];
        while (i < mid && j < end) {
            if (nums[i] <= nums[j]) {
                tmp[ct++] = nums[i++];
            } else {
                tmp[ct++] = nums[j++];
            }
        }
        while (i < mid) {
            tmp[ct++] = nums[i++];
        }
        while (j < end) {
            tmp[ct++] = nums[j++];
        }
        for (size_t k = 0; k < len; ++k) {
            nums[start + k] = tmp[k];
        }
    }
};
