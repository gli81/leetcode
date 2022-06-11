# -*- coding: utf-8 -*-

class CombinationSumII:
    def combinationSum2(self, candidates: "list[int]", target: "int") -> "list[list[int]]":
        ans = []
        self.combSum2_(ans, candidates, [], target, 0)
        return ans

    def combSum2_(self, ans: "list[list[int]]", candidates: "list[int]", current: "list[int]", remain: "int", start: "int"):
        if remain < 0: return
        elif remain == 0: ans.append(current[:])
        else:
            for i in range(start + 1, len(candidates)):
                current.append(candidates[i])
                self.combSum2_(ans, candidates, current, remain - candidates[i], i)
                current.pop()
    
    def rmDup(self, alist: "list[list[int]]") -> "list[list[int]]":
        ans: "dict[str, str]" = {}
        for i in range(len(alist)):
            l = sorted(alist[i])
            key = ''
            for j in range(len(l)):
                key = key + l[j]
                if j != len(l) - 1:
                    key += ','
            ans[key] = ''
        list_ans = []
        for item in ans.keys():
            l = item.split(',')
            temp = 
            for num in l:

def main():
    test = CombinationSumII()
    print(test.combinationSum2())

if __name__ == "__main__":
    main()
