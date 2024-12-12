# -*- coding: utf-8 -*-

from typing import List

class RotateArray:
    def rotate(self, nums: "List[int]",
               k: "int") -> "None":
        n = len(nums)
        ## k < 10^4
        ## 先取余一下，看要挪几格
        k = k % n
        if k == 0: return
        ## [1, 2, 3, 4, 5, 6, 7]
        ## k = 3
        ## 前三个会被替换
        ## 替换的时候用一个变量暂存一下
        """
        """
        ## 分类能整除和不能整除
        ## 遇到[1, 2, 3, 4, 5, 6] k = 4
        ## 一样会遍历不到某些元素
        ## 涉及最小公倍数lcm和最大公约数gcd
        ## 不想写helper function了
        if n % k != 0:
            start = k ## 被替换的index
            pre = nums[start] ## 暂存
            ind = 0 ## 替换别人的
            for _ in range(n - 1):
                nums[start] = nums[ind]
                start = ind
                ind = (ind + n - k) % n
                # print(nums)
                # print('-' * 50)
            nums[start] = pre
        ## [-1, -100, 3, 99]的情况
        ## -1和3唱双簧换来换去
        ## 那就初始index都+1再换一次
        ## 改分len(nums)能不能被k整除
        ## 不能被整除就像上面那样
        ## 能被整除就
        else:
            ## 需要分成k组
            ## 每一组进行len(nums) // k - 1次替换
            ## 并在最后进行pre的替换
            for i in range(k):
                start = k + i
                pre = nums[start]
                ind = i
                for _ in range(n // k - 1):
                    nums[start] = nums[ind]
                    start = ind
                    ind = (ind + n - k) % n
                nums[start] = pre

    def rotate2(self, nums: "List[int]",
                k: "int") -> "None":
        """
        开摆\n
        直接brute force
        exceeds time limit
        """
        n = len(nums)
        k = k % n
        for _ in range(k):
            tmp = nums[n - 1]
            for j in range(n - 1):
                nums[n - j - 1] = nums[n - j - 2]
            nums[0] = tmp

    def rotate3(self, nums: "List[int]",
                k: "int") -> "None":
        """
        抄个翻转数组过来
        """
        n = len(nums)
        k = k % n
        if k == 0: return
        ## 先全部翻转
        nums.reverse()
        ## 在第k个元素后截取翻转
        self.__reverse(nums, k, n - 1)
        ## 在第k个元素前截取翻转
        self.__reverse(nums, 0, k - 1)
        # for i in range(k // 2):
        #     nums[i], nums[k - i]\
        #         = nums[k - i], nums[i]

    def __reverse(self, nums, start, end) -> "None":

        while start < end:
            nums[start], nums[end]\
                = nums[end], nums[start]
            start += 1
            end -= 1


def main():
    test = RotateArray()
    t1 = [1, 2, 3, 4, 5, 6, 7]
    test.rotate3(t1, 3)
    print(t1)
    t2 = [-1, -100, 3, 99]
    test.rotate3(t2, 2)
    print(t2)
    t3 = [1, 2, 3, 4, 5, 6]
    test.rotate3(t3, 3)
    print(t3)
    t4 = [1, 2, 3, 4, 5, 6]
    test.rotate3(t4, 2)
    print(t4)
    t5 = [1]
    test.rotate3(t5, 1)
    print(t5)

if __name__ == "__main__":
    main()
