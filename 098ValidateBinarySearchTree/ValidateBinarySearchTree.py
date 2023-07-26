# -*- coding:utf-8 -*-

from typing import Optional, List

class ValidateBinarySearchTree:
    def isValidBST1(self,
                   root: "Optional[TreeNode]") -> "bool":
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

    def inorder_traversal_stack(self,
                            root: "Optional[TreeNode]") -> "None":
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

    def isValidBST0(self,
                    root: "Optional[TreeNode]") -> "bool":
        ans = []
        self.__inorder_traversal(root, ans)
        print(ans)
        for i in range(1, len(ans)):
            if ans[i] <= ans[i - 1]:
                return False
        return True

    def __inorder_traversal(self,
                            root: "Optional[TreeNode]",
                            ans: "List[int]") -> "None":
        if not root: return
        self.__inorder_traversal(root.left, ans)
        ans.append(root.val)
        self.__inorder_traversal(root.right, ans)
        return


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def main():
    test = ValidateBinarySearchTree()
    test1 = TreeNode(2,
                     TreeNode(1),
                     TreeNode(3))
    print(test.isValidBST0(test1))
    test2 = TreeNode(5,
                     TreeNode(1),
                     TreeNode(4,
                              TreeNode(3),
                              TreeNode(6)))
    print(test.isValidBST0(test2))
    # test.inorder_traversal_stack(test1)
    # test.inorder_traversal_stack(test2)
    test3 = TreeNode(34,
                     TreeNode(-6,
                              TreeNode(-21)))
    print(test.isValidBST0(test3))
    # test.inorder_traversal_stack(test3)


if __name__ == "__main__":
    main()
