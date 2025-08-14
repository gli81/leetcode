# -*- coding: utf-8 -*-

import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from node_structure.TreeNode import TreeNode
from typing import Optional

class PathSumIII:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        if root is None: return 0
        ans = self.__rootSum(root, targetSum)
        ans += self.pathSum(root.left, targetSum)
        ans += self.pathSum(root.right, targetSum)
        return ans

    def __rootSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        """
        helper function that calculates the number of paths that sum to
        targetSum including the current root
        """
        ans = 0
        if root is None: return ans
        val = root.val
        if val == targetSum:
            ans += 1
        ans += self.__rootSum(root.left, targetSum - val)
        ## targetSum - val so root is definitely included in path
        ans += self.__rootSum(root.right, targetSum - val)
        return ans


def main():
    test = PathSumIII()

if __name__ == "__main__":
    main()
