# -*- coding: utf-8 -*-

import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from node_structure.TreeNode import TreeNode

class CountGoodNodesinBinaryTree:
    def goodNodes(self, root: "TreeNode") -> "int":
        return self.__dfs(root, root.val)

    def __dfs(self, root: "TreeNode", maxVal: "int") -> "int":
        if not root: return 0
        cur = 1 if root.val >= maxVal else 0
        return self.__dfs(root.left, max(maxVal, root.val)) + \
            self.__dfs(root.right, max(maxVal, root.val)) + cur


def main():
    test = CountGoodNodesinBinaryTree()
    print(test.goodNodes(
        TreeNode.fromList([2, 1, 1, 3, None, 1, 5])
    ))
    print(test.goodNodes(
        TreeNode.fromList([1, 2, -1, 3, 4])
    ))

if __name__ == "__main__":
    main()
