package nodestructure

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func (node *ListNode) String() string {
	ans := fmt.Sprintf("[%d", node.Val)
	cur := node
	for cur.Next != nil {
		ans = ans + fmt.Sprintf(", %d", cur.Next.Val)
		cur = cur.Next
	}
	ans += "]"
	return ans
}

func ListNodeFromList(lst []int) *ListNode {
	if len(lst) == 0 {
		return nil
	}
	ans := &ListNode{Val: lst[0], Next: nil}
	cur := ans
	for i, v := range lst {
		if i != 0 {
			cur.Next = &ListNode{Val: v, Next: nil}
			cur = cur.Next
		}
	}
	return ans
}
