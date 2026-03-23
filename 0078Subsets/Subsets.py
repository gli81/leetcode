# -*- coding: utf -8-*-

from typing import List

class Subsets:
    def subsets(self, nums: "List[int]") -> "List[List[int]]":
        ans = []
        self.__get_ans(nums, ans, [], 0)
        return ans

    def __get_ans(self, nums: "List[int]",
                  ans: "List[List[int]]", cur: "List[int]",
                  start: "int") -> "None":
        ans.append(cur[:])
        for i in range(start, len(nums)):
            cur.append(nums[i])
            self.__get_ans(nums, ans, cur, i + 1)
            cur.pop()


def main():
    test = Subsets()
    print(test.subsets([1, 2, 3]))
    print(test.subsets([0]))

if __name__ == "__main__":
    main()
