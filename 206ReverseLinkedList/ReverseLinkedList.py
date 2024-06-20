# -*- coding: utf-8 -*-

from typing import Optional

class ReverseLinkedList:
    def reverseList(
        self,
        head: "Optional[ListNode]"
    ) -> "Optional[ListNode]":
        prev, cur = None, head
        while cur:
            tmp = cur.next
            cur.next = prev
            prev = cur
            cur = tmp
        return prev


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def main():
    test = ReverseLinkedList()

if __name__ == "__main__":
    main()
