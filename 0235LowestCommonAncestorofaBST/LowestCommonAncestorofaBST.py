# -*- coding: utf-8 -*-

import os
import sys
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from node_structure.TreeNode import TreeNode

class LowestCommonAncestorofaBST:
    def lowestCommonAncestor2(
        self,
        root: "TreeNode",
        p: "TreeNode",
        q: "TreeNode"
    ) -> "TreeNode":
        pval = p.val
        qval = q.val
        while 1:
            if root and pval > root.val and qval > root.val:
                root = root.right
            elif root and pval < root.val and qval < root.val:
                root = root.left
            else:
                return root


def main():
    test = LowestCommonAncestorofaBST()
    print(test.lowestCommonAncestor2(
        TreeNode.fromList([5, 3, 8, 1, 4, 7, 9, None, 2]),
        TreeNode(3),
        TreeNode(8)
    ))

if __name__ == "__main__":
    main()
