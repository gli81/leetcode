
class TwoSum2:
    def twoSum(self, nums : list[int],
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


nums = [2, 5, 8, 2, 7, 87]
target = 10
print(TwoSum2().twoSum(nums, target))

