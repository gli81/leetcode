# -*- coding: utf-8 -*-

import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from node_structure.TreeNode import TreeNode
from typing import Optional, List

class BinaryTreeRightSideView:
    def rightSideView1(self, root: "Optional[TreeNode]") -> "List[int]":
        """
        bfs, append right most element in each level
        """
        if not root: return []
        ans = []
        q = [root]
        while q:
            qsize = len(q)
            for i in range(qsize):
                cur = q.pop(0)
                if cur.left: q.append(cur.left)
                if cur.right: q.append(cur.right)
                if i == qsize - 1:
                    ans.append(cur.val)
        return ans


def main():
    test = BinaryTreeRightSideView()
    print(test.rightSideView1(
        TreeNode.fromList([1, 2, 3])
    ))

if __name__ == "__main__":
    main()
