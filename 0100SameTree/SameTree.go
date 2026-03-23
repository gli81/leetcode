package main

import (
	"fmt"
	nodestructure "leetcode/node_structure"
)

func isSameTree(p *nodestructure.TreeNode, q *nodestructure.TreeNode) bool {
	if nil == p && nil == q {
		return true
	}
	if nil == p || nil == q {
		return false
	}
	// left sub
	if !isSameTree(p.Left, q.Left) {
		return false
	}
	if p.Val != q.Val {
		return false
	}
	// right sub
	if !isSameTree(p.Right, q.Right) {
		return false
	}
	return true
}

func main() {
	fmt.Println("wait from TreeNode")
}
