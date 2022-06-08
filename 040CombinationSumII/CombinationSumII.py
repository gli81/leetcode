# -*- coding: utf-8 -*-

class CombinationSumII:
    def combinationSum2(self, candidates: "list[int]", target: "int") -> "list[list[int]]":
        ans = []
        combSum2_(ans)
        return ans

    def combSum2_(self, ans: "list[list[int]]", candidates: "list[int]", current: "list[int]", remain: "int", start: "int"):
        if remain < 0: return
        elif remain == 0: ans.append(current[:])
        else:
            for i in range(start + 1, len(candidates)):
                current.append(candidates[i])
                self.combSum2_(ans, candidates, current, remain - candidates[i], i)
                current.pop()

def main():
    test = CombinationSumII()
    print(test.combinationSum2())

if __name__ == "__main__":
    main()
