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
