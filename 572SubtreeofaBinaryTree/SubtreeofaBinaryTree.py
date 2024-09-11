# -*- coding: utf-8 -*-

import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from node_structure.TreeNode import TreeNode
from typing import Optional

class SubtreeofaBinaryTree():
    def isSubtree2(
        self,
        root: "Optional[TreeNode]",
        subRoot: "Optional[TreeNode]"
    ) -> "bool":
        if not subRoot: return True
        if not root: return False
        if self.__isSameTree(root, subRoot): return True
        return self.isSubtree2(root.left, subRoot) \
            or self.isSubtree2(root.right, subRoot)

    def __isSameTree(
        self,
        p: "Optional[TreeNode]",
        q: "Optional[TreeNode]"
    ) -> "bool":
        if not p and not q: return True
        if not p or not q: return False
        ## left sub
        if not self.__isSameTree(p.left, q.left): return False
        ## node
        if p.val != q.val: return False
        ## right sub
        if not self.__isSameTree(p.right, q.right): return False
        return True


def main():
    test = SubtreeofaBinaryTree()
    print(test.isSubtree2(
        TreeNode.fromList([3, 4, 5, 1, 2]),
        TreeNode.fromList([4, 1, 2])
    ))

if __name__ == "__main__":
    main()
