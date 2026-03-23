# -*- coding: utf-8 -*-

import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from node_structure.TreeNode import TreeNode
from typing import Optional

class BinaryTreeMaxPathSum:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        if not root: return 0
        self.__ans = root.val
        self.__helper(root)
        return self.__ans

    def __helper(self,root: Optional[TreeNode]) -> int:
        if not root: return 0
        left_max = max(self.__helper(root.left), 0)
        right_max = max(self.__helper(root.right), 0)
        ## when update, calculate the sum of entire subtree
        self.__ans = max(self.__ans, left_max + right_max + root.val)
        ## only return sum of one path, not entire subtree
        ## subtree wont be able to form path with ancestors
        return root.val + max(left_max, right_max)


def main():
    test = BinaryTreeMaxPathSum()
    print(test.maxPathSum(TreeNode.fromList([1, 2, 3])))
    print(test.maxPathSum(TreeNode.fromList([
        -15,
        10, 20,
        None, None, 15, 5,
        None, None, None, None, -5
    ])))

if __name__ == "__main__":
    main()
