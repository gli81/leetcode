# -*- coding: utf-8 -*-

import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from node_structure.TreeNode import TreeNode
from typing import Optional, Tuple

class DiameterofBinaryTree:
    def diameterOfBinaryTree1a(self, root: "Optional[TreeNode]") -> "int":
        ans = 0
        l, ans = self.__depth1a(root.left, ans)
        r, ans = self.__depth1a(root.right, ans)
        # print(f"l: {l}, r: {r}, ans: {ans}")
        return max(l + r + 1, ans) - 1

    def __depth1a(
        self,
        root: "Optional[TreeNode]",
        ans: "int"
    ) -> "Tuple[int, int]":
        """

        Returns
        ----------
            Tuple[int, int] : largest depth at node, current ans
        """
        if not root: return 0, ans
        # if not root.left and not root.right: return 1
        l, ans = self.__depth1a(root.left, ans)
        r, ans = self.__depth1a(root.right, ans)
        # if root:
        #     print(f"node: {root.val}")
        #     print(f"l: {left}, r: {right}")
        #     print(f"ans: {ans}")
        ans = max(l + r + 1, ans)
        return (max(l, r) + 1, max(l + r + 1, ans))

    def diameterOfBinaryTree1b(self, root: "Optional[TreeNode]") -> "int":
        ans = [0]
        l = self.__depth1b(root.left, ans)
        r = self.__depth1b(root.right, ans)
        return max(l + r + 1, ans[0]) - 1

    def __depth1b(
        self,
        root: "Optional[TreeNode]",
        ans: "int"
    ) -> "int":
        """

        Returns
        ----------
            int : largest depth at node
        """
        if not root: return 0
        # if not root.left and not root.right: return 1
        l = self.__depth1b(root.left, ans)
        r = self.__depth1b(root.right, ans)
        # if root:
        #     print(f"node: {root.val}")
        #     print(f"l: {left}, r: {right}")
        #     print(f"ans: {ans}")
        ans[0] = max(l + r + 1, ans[0])
        return max(l, r) + 1


def main():
    test = DiameterofBinaryTree()
    print(test.diameterOfBinaryTree1a(
        TreeNode.fromList([1, 2, 3, 4, 5, ])
    ))
    print(test.diameterOfBinaryTree1a(
        TreeNode.fromList(
            [1, None, 2, None, None, 3, 4, None, None, None, None, 5, ]
        )
    ))
    print(test.diameterOfBinaryTree1a(
        TreeNode.fromList(
            [
                1, None, 2, None, None, 3, 4, None, None, None, None,
                None, 5, None, 6
            ]
        )
    ))

if __name__ == "__main__":
    main()
