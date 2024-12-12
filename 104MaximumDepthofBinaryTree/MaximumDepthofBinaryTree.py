# -*- coding: utf-8 -*-

from typing import Optional
import sys
import os
sys.path.insert(0, os.path.abspath('..'))
from node_structure.TreeNode import TreeNode

class MaximumDepthofBinaryTree:
    def maxDepth1(
        self,
        root: "Optional[TreeNode]"
    ) -> "int":
        if not root: return 0
        return (
            self.maxDepth1(root.left),
            self.maxDepth1(root.right)
        ) + 1

    def maxDepth2(
        self,
        root: "Optional[TreeNode]"
    ) -> "int":
        q = []
        ans = 0
        if root: q.append(root)
        while q:
            qsize = len(q)
            for _ in range(qsize):
                cur = q.pop(0)
                if cur.left: q.append(cur.left)
                if cur.right: q.append(cur.right)
            ans += 1
        return ans


def main():
    test = MaximumDepthofBinaryTree()

if __name__ == "__main__":
    main()
