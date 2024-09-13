package main

import (
	"fmt"
	nodestructure "leetcode/node_structure"
)

/*
BFS
*/
func rightSideView(root *nodestructure.TreeNode) []int {
	ans := []int{}
	if nil == root {
		return ans
	}
	q := []*nodestructure.TreeNode{root}
	for len(q) > 0 {
		qsize := len(q)
		for i := 0; i < qsize; i++ {
			cur := q[0]
			q = q[1:]
			if nil != cur.Left {
				q = append(q, cur.Left)
			}
			if nil != cur.Right {
				q = append(q, cur.Right)
			}
			if i == qsize-1 {
				ans = append(ans, cur.Val)
			}
		}
	}
	return ans
}

func main() {
	fmt.Println("wait for TreeNode")
}
