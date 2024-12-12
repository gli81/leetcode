# -*- coding: utf-8 -*-

from typing import List

class Permutations():
    def permute1(self, nums: "List[int]") -> "List[List[int]]":
        return self.__permute_end(nums, len(nums) - 1)
    
    def __permute_end(self, nums: "List[int]", end: "int") -> "List[List[int]]":
        ## only one number
        if end == 0:
            all_ = []
            temp = []
            temp.append(nums[0])
            all_.append(temp[:])
            return all_
        ## without the last element
        all_end = self.__permute_end(nums, end - 1)
        current_size = len(all_end)
        for j in range(current_size):
            for k in range(end + 1):
                temp = all_end[j][:]
                temp.insert(k, nums[end])
                all_end.append(temp)
        for _ in range(current_size):
            all_end.pop(0)
        return  all_end
    
    def permute2(self, nums: "List[int]") -> "List[List[int]]":
        ans = []
        self.__perm2Helper(nums, ans, [])
        return ans
    
    def __perm2Helper(
        self,
        nums: "List[int]",
        ans: "List[List[int]]",
        cur: "List[int]"
    ) -> "None":
        if len(nums) == len(cur):
            ans.append(cur.copy())
        else:
            for i in range(len(nums)):
                if nums[i] in cur:
                    continue
                cur.append(nums[i])
                self.__perm2Helper(nums, ans, cur)
                cur.pop()
        

def main():
    test = Permutations()
    print(test.permute1([1, 2, 3]))
    ## private method
    # print(test.__permute_end([1, 2, 3], 0))

if __name__ == "__main__":
    main()
