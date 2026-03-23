# -*- coding: utf-8 -*-

import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from node_structure.TreeNode import TreeNode
from typing import List

class LevelOrderTraversalofBinaryTree:
    def levelOrder(
        self,
        root: "TreeNode"
    ) -> "List[List[int]]":
        if not root: return []
        ans = []
        q = [root]
        level = 0
        while q:
            qsize = len(q)
            ans.append([])
            for _ in range(qsize):
                cur = q.pop(0)
                ans[level].append(cur.val)
                if cur.left: q.append(cur.left)
                if cur.right: q.append(cur.right)
            # print(ans)
            level += 1
        return ans


def main():
    test = LevelOrderTraversalofBinaryTree()
    print(test.levelOrder(TreeNode.fromList([1, 2, 3, 4, 5, 6, 7])))

if __name__ == "__main__":
    main()
