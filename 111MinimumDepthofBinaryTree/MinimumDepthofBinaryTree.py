# -*- coding: utf-8 -*-

import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from node_structure.TreeNode import TreeNode
from typing import Optional

class MinimumDepthofBinaryTree:
    def minDepth(
        self,
        root: "Optional[TreeNode]"
    ) -> "int":
        if not root: return 0
        ans = 1
        q = []
        q.append(root)
        while q:
            qsize = len(q)
            for i in range(qsize):
                cur = q.pop(0)
                if not cur.left and not cur.right:
                    return ans
                if cur.left: q.append(cur.left)
                if cur.right: q.append(cur.right)
            ans += 1
        return -1