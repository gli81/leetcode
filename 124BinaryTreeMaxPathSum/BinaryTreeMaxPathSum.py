# -*- coding: utf-8 -*-

import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from node_structure.TreeNode import TreeNode
from typing import Optional, List

class BinaryTreeMaxPathSum:
    def maxPathSum(
        self,
        root: "Optional[TreeNode]"
    ) -> "int":
        if not root: return 0
        ans = [root.val]
        self.__helper(root, ans)
        return ans[0]

    def __helper(
        self,
        root: "Optional[TreeNode]",
        ans: "List[int]"
    ) -> "int":
        if not root: return 0
        left_max = max(self.__helper(root.left, ans), 0)
        right_max = max(self.__helper(root.right, ans), 0)
        ans[0] = max(ans[0], left_max + right_max + root.val)
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
