# -*- coding: utf-8 -*-

from typing import List

class CombinationSum:
    def combinationSum(
        self,
        candidates: "List[int]",
        target: "int"
    ) -> "List[List[int]]":
        ans = []
        self.__combSum_(ans, candidates, [], target, 0)
        return ans
    
    def __combSum_(
        self,
        ans: "List[List[int]]",
        candidates: "List[int]",
        current: "List[int]",
        remain: "int",
        start: "int"
    ) -> "None":
        if remain < 0: return
        elif remain == 0: ans.append(current[:])
        else:
            for i in range(start, len(candidates)):
                current.append(candidates[i])
                self.combSum_(
                    ans,
                    candidates,
                    current,
                    remain - candidates[i],
                    i
                )
                current.pop()


def main():
    test = CombinationSum()
    print(test.combinationSum([2, 3, 6, 7], 7))

if __name__ == "__main__":
    main()
