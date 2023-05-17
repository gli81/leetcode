# -*- coding: utf -8-*-

from typing import List

class SubsetsII:
    def subsetsWithDup(self,
                       nums: "List[int]") -> "List[List[int]]":
        ans = []
        nums.sort()
        self.__subsets_helper(nums, [], ans)
        return ans

    def __subsets_helper(self,
                         nums: "List[int]",
                         cur: "List[int]",
                         ans: "List[List[int]]") -> "None":
        pass


def main():
    test = SubsetsII()
    print(test.subsetsWithDup([1, 2, 2]))
    print(test.subsetsWithDup([0]))

if __name__ == "__main__":
    main()
