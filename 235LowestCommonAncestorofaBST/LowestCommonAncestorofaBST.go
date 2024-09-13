package main

import (
	"fmt"
	nodestructure "leetcode/node_structure"
)

func lowestCommonAncestor2(
	root, p, q *nodestructure.TreeNode,
) *nodestructure.TreeNode {
	pval := p.Val
	qval := q.Val
	for {
		if nil != root && pval > root.Val && qval > root.Val {
			root = root.Right
		} else if nil != root && pval < root.Val && qval < root.Val {
			root = root.Left
		} else {
			return root
		}
	}
	return nil
}

func main() {
	fmt.Println("wait for TreeNode")
}
