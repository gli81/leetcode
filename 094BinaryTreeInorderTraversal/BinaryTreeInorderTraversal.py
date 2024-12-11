# -*- coding: utf -8-*-

from typing import Optional, List
import os
import sys
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from node_structure.TreeNode import TreeNode

class BinaryTreeInorderTraversal:
    def inorderTraversal(
        self, root: "Optional[TreeNode]"
    ) -> "List[int]":
        ans = []
        self.__get_ans(root, ans)
        return ans
    
    def __get_ans(
        self, node: "Optional[TreeNode]", ans: "List[int]"
    ) -> "None":
        if node is None: return
        self.__get_ans(node.left, ans)
        ans.append(node.val)
        self.__get_ans(node.right, ans)


def main():
    test = BinaryTreeInorderTraversal()

if __name__ == "__main__":
    main()

