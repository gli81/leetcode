# -*- coding: utf-8 -*-

import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from node_structure.TreeNode import TreeNode
from typing import Optional

class SymmetricTree:
    def isSymmetric1(self, root: "Optional[TreeNode]") -> "bool":
        return self.__isSymHelper1(root.left, root.right)

    def __isSymHelper1(
        self, left: "Optional[TreeNode]", right: "Optional[TreeNode]"
    ) -> "bool":
        if not left and not right: return True
        if not left or not right: return False
        if left.val != right.val: return False
        return self.__isSymHelper1(left.left, right.right) and \
            self.__isSymHelper1(left.right, right.left)


def main():
    test = SymmetricTree()
    print(test.isSymmetric1(TreeNode.fromList([1, 2, 2, 3, 4, 4, 3])))

if __name__ == "__main__":
    main()
