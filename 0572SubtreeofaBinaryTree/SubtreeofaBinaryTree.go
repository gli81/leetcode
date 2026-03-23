package main

import (
	"fmt"
	nodestructure "leetcode/node_structure"
)

func isSubtree2(root *nodestructure.TreeNode, subRoot *nodestructure.TreeNode) bool {
	if nil == subRoot {
		return true
	}
	if nil == root {
		return false
	}
	if isSameTree(root, subRoot) {
		return true
	}
	return isSubtree2(root.Left, subRoot) || isSubtree2(root.Right, subRoot)
}

func isSameTree(p *nodestructure.TreeNode, q *nodestructure.TreeNode) bool {
	if nil == p && nil == q {
		return true
	}
	if nil == p || nil == q {
		return false
	}
	// left
	if !isSameTree(p.Left, q.Left) {
		return false
	}
	// node
	if p.Val != q.Val {
		return false
	}
	// right
	if !isSameTree(p.Right, q.Right) {
		return false
	}
	return true
}

func main() {
	fmt.Println("Wait for TreeNode")
}
