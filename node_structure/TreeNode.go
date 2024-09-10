// -*- coding: utf-8 -*-

package nodestructure

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
	ans := "[" + node.Val
}

// func TreeNodeFromList(lst []int) *TreeNode {

// }
