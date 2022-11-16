# -*- coding: utf-8 -*-

class JumpGameII():
    def jump1(self, nums: "list[int]") -> "int":
        rslt = max_p = end = 0
        for i in range(len(nums) - 1):
            max_p = max(max_p, nums[i] + i)
            if i == end:
                end = max_p
                rslt += 1
        return rslt

def main():
    test = JumpGameII()
    print(test.jump1([2, 3, 1, 1, 4]))
    print(test.jump1([2, 3, 1, 1]))
    print(test.jump1([1, 1, 1, 1]))
    print(test.jump1([10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0]))

if __name__ == "__main__":
    main()
