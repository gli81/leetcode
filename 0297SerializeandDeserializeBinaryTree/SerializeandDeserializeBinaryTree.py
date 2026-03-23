# -*- coding: utf-8 -*-

import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from node_structure.TreeNode import TreeNode
from typing import Optional, List

class SerializeandDeserializeBinaryTree:
    def serialize1(
        self,
        root: "Optional[TreeNode]"
    ) -> "str":
        if not root: return ""
        q = []
        level = 0
        if root: q.append(root)
        while q:
            qsize = len(q)
            for _ in range(qsize):
                cur = q.pop(0)
                if cur.left: q.append(cur.left)
                if cur.right: q.append(cur.right)
            level += 1
        ans = str(root.val)
        q.append(root.left)
        q.append(root.right)
        cur_level = 1
        while q and cur_level < level:
            qsize = len(q)
            for _ in range(qsize):
                cur = q.pop(0)
                if cur:
                    ans += "@" + str(cur.val)
                    q.append(cur.left)
                    q.append(cur.right)
                else:
                    ans += "@None"
                    q.append(None)
                    q.append(None)
            cur_level += 1
        return ans

    def serialize2(
        self,
        root: "Optional[TreeNode]"
    ) -> "str":
        if not root: return ''
        q = []
        ans = str(root.val)
        q.append(root.left)
        q.append(root.right)
        while q:
            cur = q.pop(0)
            if cur:
                ans += "@" + str(cur.val)
                q.append(cur.left)
                q.append(cur.right)
            else:
                ans += "@None"
        return ans

    def deserialize1(
        self,
        data: "str"
    ) -> "Optional[TreeNode]":
        if not data: return None
        lst = data.split('@')
        n = len(lst)
        if not n: return None
        ans: "List[TreeNode]" = [None for _ in range(n)]
        ans[0] = None if lst[0] == "None" else TreeNode(int(lst[0]))
        for i in range(1, n):
            if lst[i] != "None":
                if ans[(i - 1) // 2]:
                    ans[i] = TreeNode(int(lst[i]))
                    if i % 2 == 1:
                        ans[(i - 1) // 2].left = ans[i]
                    else:
                        ans[(i - 1) // 2].right = ans[i]
                else:
                    return None
        return ans[0]

    def deserialize2(
        self,
        data: "str"
    ) -> "Optional[TreeNode]":
        if not data: return None
        lst = data.split('@')
        ans = TreeNode(int(lst[0]))
        parents = []
        parent = ans
        cur = None
        isLeft = True
        for i in range(1, len(lst)):
            if lst[i] == "None":
                cur = None
            else:
                cur = TreeNode(int(lst[i]))
            if isLeft:
                parent.left = cur
            else:
                parent.right = cur
            isLeft = not isLeft
            if cur:
                parents.append(cur) ## only non None nodes are in here
            if isLeft:
                parent = parents.pop(0) if parents else None
        return ans


def main():
    test = SerializeandDeserializeBinaryTree()
    test1 = TreeNode.fromList([1, 2, 3, None, None, 4, 5])
    ser1 = test.serialize1(test1)
    print(ser1)
    print(test.deserialize1(ser1))
    ser11 = test.serialize2(test1)
    print(ser11)
    print(test.deserialize2(ser11))

if __name__ == "__main__":
    main()
