package main

import (
	"fmt"
	nodestructure "leetcode/node_structure"
)

func isBalanced1(root *nodestructure.TreeNode) bool {
	if nil == root {
		return true
	}
	l := depth(root.Left)
	r := depth(root.Right)
	return l <= r+1 && r <= l+1 &&
		isBalanced1(root.Left) && isBalanced1(root.Right)
}

func depth(root *nodestructure.TreeNode) int {
	if nil == root {
		return 0
	}
	return max(depth(root.Left), depth(root.Right)) + 1
}

func main() {
	fmt.Println("Wait for ListToTreeNode")
}
