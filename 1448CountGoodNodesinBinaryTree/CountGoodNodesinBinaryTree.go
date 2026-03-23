package main

import (
	"fmt"
	nodestructure "leetcode/node_structure"
)

func goodNodes(root *nodestructure.TreeNode) int {
	return dfs(root, (*root).Val)
}

func dfs(root *nodestructure.TreeNode, maxVal int) int {
	if nil == root {
		return 0
	}
	cur := 0
	if (*root).Val >= maxVal {
		cur = 1
	}
	return cur + dfs((*root).Left, max(maxVal, (*root).Val)) +
		dfs((*root).Right, max(maxVal, (*root).Val))
}

func main() {
	fmt.Println("Wait for TreeNode")
}
