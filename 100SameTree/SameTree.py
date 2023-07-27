# -*- coding:utf-8 -*-

from typing import Optional

class SameTree:
    def isSameTree(self, p: "Optional[TreeNode]",
                   q: "Optional[TreeNode]") -> "bool":
        return self.__inorder_traversal(p, q)

    def __inorder_traversal(self, p: "Optional[TreeNode]",
                            q: "Optional[TreeNode]") -> "bool":
        if p == None and q == None: return True
        if p == None or q == None: return False
        ## left
        if not self.__inorder_traversal(p.left, q.left):
            return False
        if p.val != q.val:
            return False
        if not self.__inorder_traversal(p.right, q.right):
            return False
        return True


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def main():
    test = SameTree()
    test11 = TreeNode(1, TreeNode(2), TreeNode(3))
    test12 = TreeNode(1, TreeNode(2), TreeNode(3))
    print(test.isSameTree(test11, test12))
    test21 = TreeNode(1, TreeNode(2))
    test22 = TreeNode(1, None, TreeNode(2))
    print(test.isSameTree(test21, test22))
    test31 = TreeNode(1, TreeNode(2), TreeNode(1))
    test32 = TreeNode(1, TreeNode(1), TreeNode(2))
    print(test.isSameTree(test31, test32))


if __name__ == "__main__":
    main()
