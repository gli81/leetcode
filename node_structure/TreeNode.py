# -*- coding: utf-8 -*-

from typing import Optional

class TreeNode:
    def __init__(
        self,
        val: "int"=0,
        left: "Optional[TreeNode]"=None,
        right: "Optional[TreeNode]"=None
    ):
        self.val = val
        self.left = left
        self.right = right
    
    # def __str__(self):
    #     pass
