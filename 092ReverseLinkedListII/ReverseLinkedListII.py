# -*- coding: utf -8-*-

from typing import Optional

class ReverseLinkedListII:
    def reverseBetween(self, head: "Optional[ListNode]",
                       left: "int",
                       right: "int") -> "Optional[ListNode]":
        if left == right: return head
        dummy: "ListNode" = ListNode(0, head)
        ct = 1
        pre = dummy
        while True:
            if ct == left:
                left1: "ListNode" = pre
                left2: "ListNode" = head
            if ct > left and ct <= right:
                temp: "ListNode" = head.next
                head.next = pre
                pre = head
                head = temp
                ct += 1
                continue
            if ct > right:
                left2.next = head
                left1.next = pre
                break
            head = head.next
            ct += 1
            pre = pre.next
        return dummy.next


class ListNode:
    def __init__(self, val = 0, next = None):
        self.val = val
        self.next = next
    
    def __str__(self):
        ans = '['
        ans += str(self.val)
        cur = self
        while cur.next:
            cur = cur.next
            ans = ans + ", " + str(cur.val)
        ans += ']'
        return ans


def main():
    test = ReverseLinkedListII()
    print(test.reverseBetween(ListNode(1,
                              ListNode(2,
                              ListNode(3,
                              ListNode(4,
                              ListNode(5))))), 2, 4))
    print(test.reverseBetween(ListNode(5), 1, 1))

if __name__ == "__main__":
    main()