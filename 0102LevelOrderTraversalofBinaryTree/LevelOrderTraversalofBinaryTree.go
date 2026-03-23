package main

import (
	"fmt"
	nodestructure "leetcode/node_structure"
)

func levelOrder(root *nodestructure.TreeNode) [][]int {
	if nil == root {
		return [][]int{}
	}
	ans := [][]int{}
	q := []*nodestructure.TreeNode{}
	q = append(q, root)
	for len(q) > 0 {
		cur := []int{}
		qsize := len(q)
		for i := 0; i < qsize; i++ {
			tmp := q[0]
			q = q[1:]
			cur = append(cur, (*tmp).Val)
			if nil != tmp.Left {
				q = append(q, tmp.Left)
			}
			if nil != tmp.Right {
				q = append(q, tmp.Right)
			}
		}
		cp := append([]int(nil), cur...)
		ans = append(ans, cp)
	}
	return ans
}

func main() {
	fmt.Println("wait for TreeNode")
}
