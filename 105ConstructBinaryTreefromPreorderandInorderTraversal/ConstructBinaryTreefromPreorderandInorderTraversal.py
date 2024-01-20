# -*- coding: utf-8 -*-

from typing import List, Optional, Dict

class ConstructBinaryTreefromPreorderandInorderTraversal:
    def buildTree(
        self,
        preorder: "List[int]",
        inorder: "List[int]"
    ) -> "Optional[TreeNode]":
        idx_map = {}
        n = len(inorder)
        for i in range(n): idx_map[inorder[i]] = i
        return self.__build_tree_helper(
            preorder, inorder,
            0, n - 1, 0, n - 1,
            idx_map
        )


    def __build_tree_helper(
        self,
        preorder: "List[int]",
        inorder: "List[int]",
        pre_l: "int", pre_r: "int",
        in_l: "int", in_r: "int",
        idx_map: "Dict[int, int]"
    ) -> "Optional[TreeNode]":
        if (pre_l > pre_r): return None
        root = TreeNode(preorder[pre_l])
        root_in_inorder = idx_map[preorder[pre_l]]
        left_end = pre_l - in_l + root_in_inorder 
        root.left = self.__build_tree_helper(
            preorder, inorder,
            pre_l + 1, left_end,
            in_l, root_in_inorder - 1,
            idx_map
        )
        root.right = self.__build_tree_helper(
            preorder, inorder,
            left_end + 1, pre_r,
            root_in_inorder + 1, in_r,
            idx_map
        )
        return root


class TreeNode:
    def __init__(
        self, 
        val = 0, 
        left = None, 
        right = None
    ):
        self.val = val
        self.left = left
        self.right = right


def main():
    test = ConstructBinaryTreefromPreorderandInorderTraversal()
    print(test.buildTree(
        [3, 9, 20, 15, 7], [9, 3, 15, 20, 7]
    ))
    print(test.buildTree(
        [-1], [-1]
    ))

if __name__ == "__main__":
    main()
