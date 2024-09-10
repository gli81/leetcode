// -*- coding: utf-8 -*-

package nodestructure

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func (node *TreeNode) String() string {
	q := make([]*TreeNode, 0) // queue
	level := 0
	if nil != node {
		q = append(q, node)
	}
	var cur *TreeNode
	for len(q) != 0 {
		qsize := len(q)
		for i := 0; i < qsize; i++ {
			cur, q = q[0], q[1:]
			if nil != cur.Left {
				q = append(q, cur.Left)
			}
			if nil != cur.Right {
				q = append(q, cur.Right)
			}
			level++
		}
	}
	ans := fmt.Sprintf("[%d", node.Val)
	q = append(q, node.Left)
	q = append(q, node.Right)
	cur_level := 1
	for len(q) != 0 && cur_level < level {
		qsize := len(q)
		for i := 0; i < qsize; i++ {
			cur, q = q[0], q[1:]
			if nil == cur {
				ans += ", nil"
				q = append(q, nil, nil)
			} else {
				ans += fmt.Sprintf(", %d", cur.Val)
				q = append(q, cur.Left, cur.Right)
			}
		}
		cur_level++
	}
	ans += "]"
	return ans
}

// func TreeNodeFromList(lst []int) *TreeNode {
// TODO ask Drew kkkkk
// }
