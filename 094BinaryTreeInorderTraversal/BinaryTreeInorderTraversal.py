# -*- coding: utf -8-*-

from typing import Optional, List

class BinaryTreeInorderTraversal:
    def inorderTraversal(self, root: "Optional[TreeNode]")\
                        -> "List[int]":
        ans = []
        self.__get_ans(root, ans)
        return ans
    
    def __get_ans(self, node: "Optional[TreeNode]",
                  ans: "List[int]") -> "None":
        if node == None: return
        self.__get_ans(node.left, ans)
        ans.append(node.val)
        self.__get_ans(node.right, ans)


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def main():
    test = BinaryTreeInorderTraversal()

if __name__ == "__main__":
    main()

