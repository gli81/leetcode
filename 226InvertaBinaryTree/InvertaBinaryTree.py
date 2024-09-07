# -*- coding: utf-8 -*-

import os
import sys
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from node_structure.TreeNode import TreeNode
from typing import Optional

class InvertaBinaryTree:
    def invertTree(
        self,
        root: "Optional[TreeNode]"
    ) -> "Optional[TreeNode]":
        if not root: return root
        root.left, root.right = root.right, root.left
        self.invertTree(root.left)
        self.invertTree(root.right)
        return root


def main():
    test = InvertaBinaryTree()
    print(test.invertTree(
        TreeNode.fromList([1, None, 3, None, None, 6, 7])
    ))

if __name__ == "__main__":
    main()
