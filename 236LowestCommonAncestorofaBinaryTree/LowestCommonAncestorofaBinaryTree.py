# -*- coding: utf-8 -*-

import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from node_structure.TreeNode import TreeNode
from typing import Optional

class LowestCommonAncestorOfBinaryTree:
    def lowestCommonAncestor(
        self, root: TreeNode, p: TreeNode, q: TreeNode
    ) -> Optional[TreeNode]:
        """
        dfs
        """
        self.__ans = None
        self.__dfs(root, p, q)
        return self.__ans

    def __dfs(
        self, node: Optional[TreeNode], p: TreeNode, q: TreeNode
    ) -> bool:
        if node is None:
            return False
        lson = self.__dfs(node.left, p, q)
        rson = self.__dfs(node.right, p, q)
        if (lson and rson) or (
            (node.val == p.val or node.val == q.val) and (lson or rson)
        ):
            ans = node
        return lson or rson or (node.val == p.val or node.val == q.val)
            ## left subtree is the LCA or
            ## right subtree is the LCA or
            ## node contains either p or q


def main():
    test = LowestCommonAncestorOfBinaryTree()

if __name__ == "__main__":
    main()
