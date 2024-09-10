# -*- coding: utf-u -*-

import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from node_structure.TreeNode import TreeNode
from typing import Optional

class DiameterofBinaryTree:
    def diameterOfBinaryTree(self, root: "Optional[TreeNode]") -> "int":
        pass


def main():
    test = DiameterofBinaryTree()
    print(test.diameterOfBinaryTree())

if __name__ == "__main__":
    main()
