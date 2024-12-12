# -*- coding:utf-8 -*-

from typing import List
import copy

class UniqueBinarySearchTreesII:
    def generateTrees2(self, n: "int") -> "List[TreeNode]":
        ans: "List[TreeNode]" = []
        if n == 0: return ans
        return self.__get_ans(1, n)
        # return ans

    def __get_ans(self, start: "int",
                        n: "int") -> "List[TreeNode]":
        ans = []
        ## exits
        if start > n:
            ans.append(None)
            return ans
        if start == n:
            ans.append(TreeNode(start))
            return ans
        ## recursion
        for i in range(start, n + 1):
            left_trees = self.__get_ans(start, i - 1)
            right_trees = self.__get_ans(i + 1, n)
            for left in left_trees:
                for right in right_trees:
                    root = TreeNode(i, left, right)
                    ans.append(root)
        return ans

    def generateTrees4(self, n: "int") -> "List[TreeNode]":
        pre = []
        if n == 0: return pre
        pre.append(None)
        ## add one number each time
        for num in range(1, n+1):
            cur = []
            for tree in pre:
                ## insert to root
                cur.append(TreeNode(num, tree, None))
                ## insert to somewhere in right child
                ## for each tree's right child
                ## there are many places
                ## where the new numcould be inserted
                for j in range(n + 1): ## control insert position with j
                    root_copy = copy.deepcopy(tree)
                    ## TODO find place to insert
                    right = root_copy ## to find place to insert
                    for _ in range(j):
                        ## go to next layer by at most j times
                        if not right: break
                        right = right.right
                    if not right: break
                    insert: "TreeNode" = TreeNode(num)
                    insert.left = right.right
                    right.right = insert
                    cur.append(root_copy)
            pre = cur[:]
        return pre


class TreeNode:
   def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def main():
    test = UniqueBinarySearchTreesII()
    print(test.generateTrees4(3))

if __name__ == "__main__":
    main()
