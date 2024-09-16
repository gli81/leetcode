# -*- coding:utf-8 -*-

import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from node_structure.TreeNode import TreeNode

class KthSmallestElementinaBST:
    def kthSmallest(
        self,
        root: "TreeNode",
        k: "int"
    ) -> "int":
        ## every pop, k -= 1, when k == 0 return
        stk = []
        stk.append(root)
        while stk:
            while root.left:
                stk.append(root.left)
                root = root.left
            root = stk.pop()
            k -= 1
            if k == 0: return root.val
            while not root.right and stk:
                root = stk.pop()
                k -= 1
                if k == 0: return root.val
            if root.right:
                stk.append(root.right)
                root = root.right


def main():
    test = KthSmallestElementinaBST()
    print(test.kthSmallest(TreeNode.fromList([2, 1, 3]), 2))

if __name__ == "__main__":
    main()
