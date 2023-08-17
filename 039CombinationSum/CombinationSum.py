# -*- coding: utf-8 -*-

class CombinationSum:
    def combinationSum(self, candidates: "list[int]",
                       target: "int")\
                        -> "list[list[int]]":
        ans = []
        self.combSum_(ans, candidates, [], target, 0)
        return ans
    
    def combSum_(self, ans: "list[list[int]]",
                 candidates: "list[int]",
                 current: "list[int]",
                 remain: "int",
                 start: "int") -> "None":
        if remain < 0: return
        elif remain == 0: ans.append(current[:])
        else:
            for i in range(start, len(candidates)):
                current.append(candidates[i])
                self.combSum_(ans, candidates, current, remain - candidates[i], i)
                current.pop()


def main():
    test = CombinationSum()
    print(test.combinationSum([2, 3, 6, 7], 7))

if __name__ == "__main__":
    main()
