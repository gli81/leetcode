
class TwoSum:
    def twoSum1(self, nums: list[int], target: int):
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]
    def twoSum2(self, nums : list[int],
                target : int) -> list[int]:
        mapp : dict[int, int] = {}
        # put everything in the map
        for i in range(len(nums)):
            mapp[nums[i]] = i
        # traverse nums
        for i in range(len(nums)):
            sub = target - nums[i]
            if sub in mapp.keys() and i != mapp[sub]:
                return [i, mapp[sub]]
        return [0, 0]

nums = [3, 26, 87, 2341, 4876, 23]
target = 2367

print(TwoSum().twoSum2(nums, target))

nums = [2, 5, 8, 2, 7, 87]
target = 10
print(TwoSum().twoSum1(nums, target))
