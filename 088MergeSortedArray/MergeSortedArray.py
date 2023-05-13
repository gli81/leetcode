# -*- coding: utf -8-*-

from typing import List

class MergeSortedArray:
    def merge(self, nums1: "List[int]", nums2: "List[int]",
              n: "int") -> "None":
        pass


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