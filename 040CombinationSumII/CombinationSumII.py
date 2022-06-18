# -*- coding: utf-8 -*-

class CombinationSumII:
    def combinationSum2(self, candidates: "list[int]", target: "int") -> "list[list[int]]":
        ans = []
        self.combSum2_(ans, candidates, [], target, 0)
        ans = self.rmDup(ans)
        return ans

    def combinationSum2b(self, candidates: "list[int]", target: "int") -> "list[list[int]]":
        ans = []
        candidates.sort()
        self.combSum2b_(ans, candidates, [], target, 0)
        # ans = self.rmDup(ans)
        return ans

    def combSum2_(self, ans: "list[list[int]]", candidates: "list[int]", current: "list[int]", remain: "int", start: "int"):
        if remain < 0: return
        elif remain == 0: ans.append(current[:])
        else:
            for i in range(start + 1, len(candidates)):
                current.append(candidates[i])
                self.combSum2_(ans, candidates, current, remain - candidates[i], i)
                current.pop()

    def combSum2b_(self, ans: "list[list[int]]", candidates: "list[int]", current: "list[int]", remain: "int", start: "int"):
        if remain < 0: return
        elif remain == 0: ans.append(current[:])
        else:
            for i in range(start, len(candidates)):
                if i > start and candidates[i] == candidates[i - 1]: continue
                current.append(candidates[i])
                self.combSum2b_(ans, candidates, current, remain - candidates[i], i + 1)
                current.pop()
    
    def rmDup(self, alist: "list[list[int]]") -> "list[list[int]]":
        ans: "dict[str, str]" = {}
        for i in range(len(alist)):
            l = sorted(alist[i])
            key = ''
            for j in range(len(l)):
                key = key + str(l[j])
                if j != len(l) - 1:
                    key += ','
            ans[key] = ''
        list_ans = []
        for item in ans.keys():
            l = item.split(',')
            temp = []
            for num in l:
                temp.append(int(num))
            list_ans.append(temp[:])
        return list_ans

def main():
    test = CombinationSumII()
    print(test.combinationSum2b([10, 1, 2, 7, 6, 1, 5], 8))

if __name__ == "__main__":
    main()
