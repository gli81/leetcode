# -*- coding: utf-8 -*-

from typing import List, Optional

class ConvertSortedArraytoBinarySearchTree:
    def sortedArrayToBST(
        self,
        nums: "List[int]"
    ) -> "Optional[TreeNode]":
        ## find median
        med_idx = len(nums) // 2
        med = nums[med_idx]
        # print(med)
        root = TreeNode(med)
        cur = root
        for num in nums[: med_idx][::-1]:
            print(num, end=', ')
            cur.left = TreeNode(num)
            cur = cur.left
        cur = root
        print()
        for num in nums[med_idx + 1:]:
            print(num, end=", ")
            cur.right = TreeNode(num)
            cur = cur.right
        return root


class TreeNode:
    def __init__(
        self,
        val = 0,
        left = None,
        right = None
    ):
        self.val = val
        self.left = left
        self.right = right


def main():
    test = ConvertSortedArraytoBinarySearchTree()
    print(test.sortedArrayToBST([-10, -3, 0, 5, 9]))
    print(test.sortedArrayToBST([0, 1, 2, 3, 4, 5]))

if __name__ == "__main__":
    main()
