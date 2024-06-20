# -*- coding: utf-8 -*-

from typing import Optional

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


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def main():
    test = MaximumDepthofBinaryTree()

if __name__ == "__main__":
    main()
