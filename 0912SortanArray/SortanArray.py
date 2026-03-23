# -*- coding: utf-8 -*-

from typing import List
import random

class SortanArray:
    def sortArray1(self, nums: "List[int]") -> "List[int]":
        """
        quick sort
        """
        self.__quickSort(nums)
        return nums

    def __quickSort(self, nums: "List[int]") -> "None":
        self.__quickSortHelper3(nums, 0, len(nums))

    def __quickSortHelper1(
        self, nums: "List[int]", start: "int", end: "int"
    ) -> "None":
        """
        pivot in the start
        11/20
        """
        ## pivots
        r = end - 1
        if start < r:
            p = start
            l = start + 1
            while True:
                while l <= r and nums[l] <= nums[p]:
                    l += 1
                while r >= l and nums[r] > nums[p]:
                    r -= 1
                ## two numbers found
                ## if not met, swap
                if l < r:
                    nums[l], nums[r] = nums[r], nums[l]
                else:
                    ## if met, end loop, put pivot ro r
                    break
            nums[r], nums[p] = nums[p], nums[r]
            # print(nums[start:end])
            ## sort two subarray
            self.__quickSortHelper1(nums, start, r)
            self.__quickSortHelper1(nums, r + 1, end)

    def __quickSortHelper2(
        self, nums: "List[int]", start: "int", end: "int"
    ) -> "None":
        """
        pivot in the middle
        14/20
        """
        ## pivots
        r = end - 1
        if start < r:
            p = (end - start) // 2 + start
            nums[p], nums[start] = nums[start], nums[p]
            l = start + 1
            while True:
                while l <= r and nums[l] <= nums[start]:
                    l += 1
                while r >= l and nums[r] > nums[start]:
                    r -= 1
                ## two numbers found
                ## if not met, swap
                if l < r:
                    nums[l], nums[r] = nums[r], nums[l]
                else:
                    ## if met, end loop, put pivot ro r
                    break
            nums[r], nums[start] = nums[start], nums[r]
            # print(nums[start:end])
            ## sort two subarray
            self.__quickSortHelper2(nums, start, r)
            self.__quickSortHelper2(nums, r + 1, end)

    def __quickSortHelper3(
        self, nums: "List[int]", start: "int", end: "int"
    ) -> "None":
        """
        pivot random
        17/21
        """
        ## pivots
        r = end - 1
        if start < r:
            p = random.randint(start, r)
            nums[p], nums[start] = nums[start], nums[p]
            l = start + 1
            while True:
                while l <= r and nums[l] <= nums[start]:
                    l += 1
                while r >= l and nums[r] > nums[start]:
                    r -= 1
                ## two numbers found
                ## if not met, swap
                if l < r:
                    nums[l], nums[r] = nums[r], nums[l]
                else:
                    ## if met, end loop, put pivot ro r
                    break
            nums[r], nums[start] = nums[start], nums[r]
            # print(nums[start:end])
            ## sort two subarray
            self.__quickSortHelper3(nums, start, r)
            self.__quickSortHelper3(nums, r + 1, end)

    def sortArray2(self, nums: "List[int]") -> "List[int]":
        """
        mergeSort
        """
        n = len(nums)
        if n <= 1: return nums
        mid = n // 2
        l = self.sortArray2(nums[:mid])
        r = self.sortArray2(nums[mid:])
        i = 0
        j = 0
        merged = [0] * n
        while i < len(l) and j < len(r):
            if l[i] <= r[j]:
                merged[i + j] = l[i]
                i += 1
            else:
                merged[i + j] = r[j]
                j += 1
        if i == len(l):
            while j < len(r):
                merged[i + j] = r[j]
                j += 1
        else:
            while i < len(l):
                merged[i + j] = l[i]
                i += 1
        # print(merged)
        return merged

    def sortArray3(self, nums: "List[int]") -> "List[int]":
        """
        heap sort
        """
        pass


def main():
    test = SortanArray()
    test1 = [5, 2, 3, 1]
    print(test.sortArray2(test1))
    # print(test1)
    test2 = [5, 1, 1, 2, 0, 0]
    print(test.sortArray2(test2))
    # print(test2)

if __name__ == "__main__":
    main()
