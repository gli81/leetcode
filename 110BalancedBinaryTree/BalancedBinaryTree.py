# -*- coding: utf-8 -*-

import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from typing import Optional
from node_structure.TreeNode import TreeNode


class BalancedBinaryTree:
    # def isBalanced(
    #     self,
    #     root: "Optional[TreeNode]"
    # ) -> "bool":
    #     if not root:
    #         return True
    #     if self.__is_leaf_or_null(root.left) and\
    #         self.__is_leaf_or_null(root.right):
    #         return True
    #     return self.isBalanced(root.left) and self.isBalanced(root.right)

    # def __is_leaf_or_null(self, root: "TreeNode") -> "bool":
    #     return not root or (not root.left and not root.right)
    def isBalanced1(
        self,
        root: "Optional[TreeNode]"
    ) -> "bool":
        if not root: return True
        r = self.__depth(root.right)
        l = self.__depth(root.left)
        print(f"l: {l}, r: {r}")
        return r <= l + 1 and l <= r + 1 and \
            self.isBalanced1(root.left) and \
            self.isBalanced1(root.right)

    def __depth(
        self,
        root: "Optional[TreeNode]"
    ) -> "int":
        if not root: return 0
        return max(self.__depth(root.left), self.__depth(root.right)) + 1


def main():
    test = BalancedBinaryTree()
    # print(test.isBalanced1(
    #     TreeNode.fromList([1, 2, 3, None, None, 4])
    # ))
    print(test.isBalanced1(
        TreeNode.fromList(
            [1, 2, 3, None, None, 4, None, None, None, None, None, 5]
        )
    ))
    print(test.isBalanced1(
        TreeNode.fromList(
            [
                1, 2, 2, 3, None, None, 3,
                4, None, None, None, None, None, None, 5
            ]
        )
    ))

if __name__ == "__main__":
    main()
