package main

import (
	"fmt"
	nodestructure "leetcode/node_structure"
)

func maxPathSum(root *nodestructure.TreeNode) int {
	if nil == root {
		return 0
	}
	ans := (*root).Val
	helper(root, &ans)
	return ans
}

func helper(root *nodestructure.TreeNode, ans *int) int {
	if nil == root {
		return 0
	}
	left_max := max(helper(root.Left, ans), 0)
	right_max := max(helper(root.Right, ans), 0)
	*ans = max(*ans, left_max+right_max+(*root).Val)
	return (*root).Val + max(left_max, right_max)
}

func main() {
	fmt.Println("Wait for TreeNode")
}
