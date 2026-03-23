package main

import (
	"fmt"
	nodestructure "leetcode/node_structure"
)

func reorderList(head *nodestructure.ListNode) {
	if head == nil || head.Next == nil {
		return
	}
	// split in two
	l := head
	r := head
	for r.Next != nil && r.Next.Next != nil {
		l = l.Next
		r = r.Next.Next
	}
	l = l.Next
	// reverse second half
	var cur *nodestructure.ListNode
	var tmp *nodestructure.ListNode
	if l.Next != nil {
		cur = l.Next
		l.Next = nil
		for cur.Next != nil {
			tmp = cur.Next
			cur.Next = l
			l = cur
			cur = tmp
		}
		cur.Next = l
	} else {
		cur = l
	}
	// merge two halves
	ans := head
	for cur.Next != nil {
		tmp = ans.Next
		ans.Next = cur
		ans = tmp
		tmp = cur.Next
		cur.Next = ans
		cur = tmp
	}
	tmp = ans.Next
	ans.Next = cur
	cur.Next = tmp
	tmp.Next = nil
}

func main() {
	test1 := &nodestructure.ListNode{Val: 1, Next: nil}
	reorderList(test1)
	fmt.Println(test1)
}
