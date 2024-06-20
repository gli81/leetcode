# -*- coding: utf-8 -*-

from typing import Optional
import sys
import os
sys.path.insert(0, os.path.abspath('..'))
from node_structure.TreeNode import TreeNode

class MaximumDepthofBinaryTree:
    def maxDepth(
        self,
        root: "Optional[TreeNode]"
    ) -> "int":
        if not root: return 0
        return (
            self.maxDepth(root.left),
            self.maxDepth(root.right)
        ) + 1


def main():
    test = MaximumDepthofBinaryTree()

if __name__ == "__main__":
    main()
