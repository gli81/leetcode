# -*- coding:utf-8 -*-

from typing import Optional, Tuple

class RecoverBinarySearchTree:
    def recoverTree(self,
                    root: "Optional[TreeNode]")\
                    -> "None":
        '''
        解决不好值传递问题
        '''
        first = None
        second = None
        first, second = self.__inorder_traversal2(root, first, second)
        # print(first, second)
        first.val, second.val = second.val, first.val

    def __inorder_traversal1(self,
                            root: "Optional[TreeNode]",
                            first: "Optional[TreeNode]"=None,
                            second: "Optional[TreeNode]"=None,
                            pre: "Optional[TreeNode]"=None)\
                            -> "None":
        if not root: return
        self.__inorder_traversal(root.left,
                                 first, second,
                                 pre)
        ##########################
        ## make changes
        print(root.val, end=', ')
        if pre: print(pre.val)
        else: print()
        if pre and pre.val >= root.val: ## something found
            if not first: ## first found
                first = pre
                second = root
            else: ## second found
                second = root
        pre = root
        ##########################
        self.__inorder_traversal(root.right,
                                 first, second,
                                 pre)

    def recoverTree(self,
                    root: "Optional[TreeNode]")\
                    -> "None":
        if not root: return
        first = None
        second = None
        stk = []
        stk.append(root)
        pre = None
        while len(stk):
            if root.left:
                stk.append(root.left)
                root = root.left
            else:
                root = stk.pop()
                if pre and pre.val >= root.val:
                    if not first:
                        first = pre
                        second = root
                    else: second = root ## second found
                pre = root
                while not root.right and len(stk):
                    root = stk.pop()
                    if pre and pre.val >= root.val:
                        if not first:
                            first = pre
                            second = root
                        else: second = root
                    pre = root
                if root.right:
                    stk.append(root.right)
                    root = root.right
        temp = first.val
        first.val = second.val
        second.val = temp

    def __inorder_traversal2(self,
                            root: "Optional[TreeNode]",
                            first: "Optional[TreeNode]"=None,
                            second: "Optional[TreeNode]"=None)\
                            -> "Tuple[TreeNode, TreeNode]":
        stk = []
        stk.append(root)
        pre = None
        while len(stk):
            if root.left:
                stk.append(root.left)
                root = root.left
            else:
                root = stk.pop()
                if pre and pre.val >= root.val:
                    if not first:
                        first = pre
                        second = root
                    else: second = root ## second found
                pre = root
                while not root.right and len(stk):
                    root = stk.pop()
                    if pre and pre.val >= root.val:
                        if not first:
                            first = pre
                            second = root
                        else: second = root
                    pre = root
                if root.right:
                    stk.append(root.right)
                    root = root.right
        return first, second


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def main():
    test = RecoverBinarySearchTree()
    test1 = TreeNode(1, TreeNode(3, None, TreeNode(2)))
    print(test.recoverTree(test1))
    test2 = TreeNode(3, TreeNode(1), TreeNode(4, TreeNode(2)))
    print(test.recoverTree(test2))


if __name__ == "__main__":
    main()
