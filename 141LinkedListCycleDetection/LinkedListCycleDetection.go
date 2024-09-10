package main

import (
	"fmt"
	nodestructure "leetcode/node_structure"
)

func hasCycle1(head *nodestructure.ListNode) bool {
	cur := head
	s := map[*nodestructure.ListNode]struct{}{}
	for nil != cur {
		if _, ok := s[cur]; ok {
			return true
		}
		s[cur] = struct{}{}
		cur = cur.Next
	}
	return false
}

func hasCycle2(head *nodestructure.ListNode) bool {
	if nil == head {
		return false
	}
	slow := head
	fast := head
	slow = slow.Next
	fast = fast.Next
	if nil == fast {
		return false
	}
	fast = fast.Next
	for nil != slow && nil != fast && nil != fast.Next && slow != fast {
		slow = slow.Next
		fast = fast.Next.Next
	}
	return slow == fast
}

func main() {
	fmt.Println(
		hasCycle2(nodestructure.ListNodeFromList([]int{1, 2, 3, 4, 5})),
	)
}
