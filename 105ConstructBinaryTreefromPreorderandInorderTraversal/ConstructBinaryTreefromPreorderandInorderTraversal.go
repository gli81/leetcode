package main

import (
	"fmt"
	nodestructure "leetcode/node_structure"
)

func buildTree(preorder []int, inorder []int) *nodestructure.TreeNode {
	// build map
	m := map[int]int{}
	n := len(inorder)
	for i := 0; i < n; i++ {
		m[inorder[i]] = i
	}
	return helper(preorder, inorder, 0, n-1, 0, n-1, m)
}

func helper(
	preorder []int, inorder []int,
	preorder_l int, preorder_r int,
	inorder_l int, inorder_r int,
	idx_map map[int]int,
) *nodestructure.TreeNode {
	if preorder_l > preorder_r {
		return nil
	}
	// create root
	root := &nodestructure.TreeNode{Val: preorder[preorder_l]}
	// find root in inorder
	root_in_inorder := idx_map[preorder[preorder_l]]
	// find left ends in preorder
	left_end := preorder_l + (root_in_inorder - inorder_l)
	(*root).Left = helper(
		preorder, inorder,
		preorder_l+1, left_end,
		inorder_l, root_in_inorder-1,
		idx_map,
	)
	(*root).Right = helper(
		preorder, inorder,
		left_end+1, preorder_r,
		root_in_inorder+1, inorder_r,
		idx_map,
	)
	return root
}

func main() {
	fmt.Println("wait for TreeNode")
}
