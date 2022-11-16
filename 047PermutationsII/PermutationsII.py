# -*- coding: utf-8 -*-

class PermutationsII():
    def permuteUnique1(self, nums: "list[int]") -> "list[list[int]]":
        ans = [[nums[0]]]
        for i in range(1, len(nums)):
            current_size = len(ans)
            for j in range(current_size):
                for k in range(len(ans[j]) + 1):
                    now = ans[j][:]
                    if k < i and nums[i] == now[k]: continue
                    now.insert(k, nums[i])
                    ans.append(now[:])
            for j in range(current_size):
                ans.pop(0)
        return self.__remove_duplicates(ans)
        # return ans
    
    def __remove_duplicates(self, nums: "list[list[int]]") -> "list[list[int]]":
        ans_set = set()
        for element in nums:
            ans_set.add(','.join(map(str, element)))
        ans = []
        for element in ans_set:
            ans.append(list(map(int, element.split(','))))
        return ans

def main():
    test = PermutationsII()
    # print(test.permuteUnique1([1, 2, 3]))
    print(test.permuteUnique1([1, 1, 2]))
    ## private method
    # print(test.__permute_end([1, 2, 3], 0))

if __name__ == "__main__":
    main()
