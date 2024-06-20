# -*- coding: utf-8 -*-

from typing import Optional
import sys
import os
sys.path.append(os.path.abspath(".."))
from node_structure.ListNode import ListNode

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


def main():
    test = ReverseLinkedList()

if __name__ == "__main__":
    main()
