package main

import node_structure "leetcode/node_structure"

func isSymmetric(root *node_structure.TreeNode) bool {
	return isSymHelper((*root).Left, (*root).Right)
}

func isSymHelper(left *node_structure.TreeNode, right *node_structure.TreeNode) bool {
	if left == nil && right == nil {
		return true
	}
	if left == nil || right == nil {
		return false
	}
	if left.Val != right.Val {
		return false
	}
	return isSymHelper(left.Left, right.Right) && isSymHelper(left.Right, right.Left)
}
