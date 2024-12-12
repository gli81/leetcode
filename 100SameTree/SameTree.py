# -*- coding:utf-8 -*-

import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from node_structure.TreeNode import TreeNode
from typing import Optional

class SameTree:
    def isSameTree(self, p: "Optional[TreeNode]",
                   q: "Optional[TreeNode]") -> "bool":
        if not p and not q: return True
        if not p or not q: return False
        ## left
        if not self.isSameTree(p.left, q.left): return False
        ## node
        if p.val != q.val: return False
        ## right
        if not self.isSameTree(p.right, q.right): return False
        return True

    # def isSameTree(self, p: "Optional[TreeNode]",
    #                q: "Optional[TreeNode]") -> "bool":
    #     return self.__inorder_traversal(p, q)

    # def __inorder_traversal(self, p: "Optional[TreeNode]",
    #                         q: "Optional[TreeNode]") -> "bool":
    #     if p == None and q == None: return True
    #     if p == None or q == None: return False
    #     ## left
    #     if not self.__inorder_traversal(p.left, q.left):
    #         return False
    #     if p.val != q.val:
    #         return False
    #     if not self.__inorder_traversal(p.right, q.right):
    #         return False
    #     return True


def main():
    test = SameTree()
    test11 = TreeNode.fromList([1, 2, 3])
    test12 = TreeNode.fromList([1, 2, 3])
    print(test.isSameTree(test11, test12))
    test21 = TreeNode.fromList([1, 2])
    test22 = TreeNode.fromList([1, None, 2])
    print(test.isSameTree(test21, test22))
    test31 = TreeNode.fromList([1, 2, 1])
    test32 = TreeNode.fromList([1, 1, 2])
    print(test.isSameTree(test31, test32))

if __name__ == "__main__":
    main()
