# -*- coding: utf-8 -*-

import os
import sys
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from typing import Optional
from node_structure.ListNode import ListNode

class MergeTwoSortedLists:
    def mergeTwoLists1(
        self, l1: "Optional[ListNode]", l2: "Optional[ListNode]"
    ) -> "Optional[ListNode]":
        h = ListNode(0)
        ans = h
        while l1 != None and l2 != None:
            if l1.val < l2.val:
                h.next = l1
                h = h.next
                l1 = l1.next
            else: 
                h.next = l2
                h = h.next
                l2 = l2.next
        if l1 == None:
            h.next = l2
        if l2 == None:
            h.next = l1
        return ans.next


def main():
    test = MergeTwoSortedLists()
    print(test.mergeTwoLists1(
        ListNode.fromList([1, 2, 4]),
        ListNode.fromList([1, 3, 4])
    ))
    print(test.mergeTwoLists1(None, None))

if __name__ == "__main__":
    main()
