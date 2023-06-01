# -*- coding: utf -8-*-

from typing import Optional

class ReverseLinkedListII:
    def reverseBetweeb(self, head: "Optional[ListNode]",
                       left: "int",
                       right: "int") -> "Optional[ListNode]":
        pass


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
    print(test.reverseBetweeb(ListNode(1,
                              ListNode(2,
                              ListNode(3,
                              ListNode(4,
                              ListNode(5))))), 2, 4))
    print(test.reverseBetweeb(ListNode(5), 1, 1))

if __name__ == "__main__":
    main()