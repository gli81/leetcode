
class TwoSum1:
    def twoSum(self, nums: list[int], target: int):
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]

nums = [3, 26, 87, 2341, 4876, 23]
target = 2367

print(TwoSum1().twoSum(nums, target))