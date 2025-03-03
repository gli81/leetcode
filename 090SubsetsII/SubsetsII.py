# -*- coding: utf -8-*-

from typing import List

class SubsetsII:
    def subsetsWithDup(self, nums: "List[int]") -> "List[List[int]]":
        ans = []
        nums.sort()
        self.__subsets_helper(0, nums, [], ans)
        return ans

    def __subsets_helper(
        self, start: "int",
        nums: "List[int]",
        cur: "List[int]",
        ans: "List[List[int]]"
    ) -> "None":
        ans.append(cur[:])
        for i in range(start, len(nums)):
            ## if current element same as the last one
            ## skip it
            # if i > 0 and nums[i] == nums[i - 1]:
            if i > start and nums[i] == nums[i - 1]:
                continue
            cur.append(nums[i])
            self.__subsets_helper(
                i + 1, nums, cur, ans
            )
            cur.pop()


def main():
    test = SubsetsII()
    print(test.subsetsWithDup([1, 2, 2]))
    print(test.subsetsWithDup([0]))

if __name__ == "__main__":
    main()
