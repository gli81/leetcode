# -*- coding:utf-8 -*-

from typing import Optional, List
import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from node_structure.TreeNode import TreeNode

class ValidateBinarySearchTree:
    def isValidBST4(
        self,
        root: "Optional[TreeNode]"
    ) -> "bool":
        if not root: return True
        stk: "List[TreeNode]" = []
        stk.append(root)
        pre = float("-inf")
        while len(stk):
            if root.left:
                stk.append(root.left)
                root = root.left
                # print([x.val for x in stk])
            else:
                root = stk.pop()
                # print([x.val for x in stk])
                # print(f"{pre} >= {root.val}?")
                if pre >= root.val: return False
                pre = root.val
                while not root.right and len(stk):
                    root = stk.pop()
                    if pre >= root.val: return False
                    pre = root.val
                if root.right:
                    stk.append(root.right)
                    root = root.right
        return True

    def inorder_traversal_stack(
        self,
        root: "Optional[TreeNode]"
    ) -> "None":
        stk: "List[TreeNode]" = []
        if not root: return
        stk.append(root)
        while len(stk):
            if root.left:
                stk.append(root.left)
                root = root.left
            else:
                root = stk.pop()
                print(root.val)
                while not root.right and len(stk):
                    root = stk.pop()
                    print(root.val)
                    # print("from here")
                if root.right:
                    stk.append(root.right)
                    root = root.right

    def isValidBST0(
        self,
        root: "Optional[TreeNode]"
    ) -> "bool":
        ans = []
        self.__inorder_traversal(root, ans)
        print(ans)
        for i in range(1, len(ans)):
            if ans[i] <= ans[i - 1]:
                return False
        return True

    def __inorder_traversal(
        self,
        root: "Optional[TreeNode]",
        ans: "List[int]"
    ) -> "None":
        if not root: return
        self.__inorder_traversal(root.left, ans)
        ans.append(root.val)
        self.__inorder_traversal(root.right, ans)
        return

    def isValidBST4b(
        self,
        root: "Optional[TreeNode]"
    ) -> "bool":
        if not root: return True
        stk: "List[TreeNode]" = []
        stk.append(root)
        pre = None
        while stk:
            while root.left:
                stk.append(root.left)
                root = root.left
            root = stk.pop()
            ## compare when pop
            if pre and pre.val >= root.val: return False
            pre = root
            while not root.right and stk:
                root = stk.pop()
                ## compare when pop
                if pre and pre.val >= root.val: return False
                pre = root
            if root.right:
                stk.append(root.right)
                root = root.right
        return True


def main():
    test = ValidateBinarySearchTree()
    test1 = TreeNode.fromList([2, 1, 3])
    print(test.isValidBST4b(test1))
    # test2 = TreeNode.fromList([5, 1, 4, None, None, 3, 6])
    # print(test.isValidBST4b(test2))
    # # test.inorder_traversal_stack(test1)
    # # test.inorder_traversal_stack(test2)
    # test3 = TreeNode.fromList([34,-6, None, -21])
    # print(test.isValidBST4b(test3))
    # # test.inorder_traversal_stack(test3)
    test4 = TreeNode.fromList([5, 4, 6, None, None, 3, 7])
    print(test.isValidBST4b(test4))
    test5 = TreeNode.fromList([32, 26, 47, 19, None, None, 56, None, 27])
    print(test.isValidBST4b(test5))
    test6 = TreeNode.fromList([3, 1, 5, 0, 2, 4, 6])
    print(test.isValidBST4b(test6))
    test7 = TreeNode.fromList([-59, None, 49, None, None, None, 78])
    print(test.isValidBST4b(test7))
    test8 = TreeNode.fromList([3, 1, 5, 0, 2, 4, 6, None, None, None, 3])
    print(test.isValidBST4b(test8))

if __name__ == "__main__":
    main()
