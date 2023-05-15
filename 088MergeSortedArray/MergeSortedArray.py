# -*- coding: utf -8-*-

from typing import List

class MergeSortedArray:
    def merge(self, nums1: "List[int]", nums2: "List[int]",
              n: "int") -> "None":
        ## move nums1 backward
        for i in range(len(nums1) - 1, n - 1, -1):
            nums1[i] = nums1[i - n]
        for i in range(n - 1, -1, -1):
            nums1[i] = 0
        ## merge sort into nums1
        total = 0
        i1 = n
        i2 = 0
        while i1 < len(nums1) and i2 < len(nums2):
            if nums1[i1] >= nums2[i2]:
                nums1[total] = nums2[i2]
                i2 += 1
                total += 1
            else:
                nums1[total] = nums1[i1]
                i1 += 1
                total += 1
        ## if not all nums in nums2 put in nums1
        # print(total, i1, i2)
        while i2 < len(nums2):
            nums1[total] = nums2[i2]
            i2 += 1
            total += 1


def main():
    test = MergeSortedArray()
    test0101: "List[int]" = [1,2,3,0,0,0]
    test0102: "List[int]" = [2, 5, 6]
    test.merge(test0101, test0102, 3)
    print(test0101)
    test0201: "List[int]" = [1]
    test0202: "List[int]" = []
    test.merge(test0201, test0202, 0)
    print(test0201)
    test0301: "List[int]" = [0]
    test0302: "List[int]" = [1]
    test.merge(test0301, test0302, 1)
    print(test0301)

if __name__ == "__main__":
    main()
