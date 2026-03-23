# -*- coding: utf-8 -*-

import os
import sys
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from node_structure.ListNode import ListNode
from typing import List, Optional

class MergeKSortedLinkedList:
    def mergeKLists(
        self,
        lists: "Optional[List[ListNode]]"
    ) -> "Optional[List]":
        if not lists: return None
        n = len(lists)
        if n == 0: return None
        interval = 1
        while interval < n:
            for i in range(0, n - interval, 2 * interval):
                lists[i] = self.__mergeTwoLists(lists[i], lists[i + interval])
            interval *= 2
        return lists[0]

    def __mergeTwoLists(
        self,
        l1: "Optional[ListNode]",
        l2: "Optional[ListNode]"
    ) -> "Optional[ListNode]":
        ans = ListNode()
        cur = ans
        while l1 and l2:
            if l1.val < l2.val:
                cur.next = l1
                cur = cur.next
                l1 = l1.next
            else:
                cur.next = l2
                cur = cur.next
                l2 = l2.next
        if l1:
            cur.next = l1
        if l2:
            cur.next = l2
        return ans.next


def main():
    test = MergeKSortedLinkedList()
    print(test.mergeKLists([
        ListNode.fromList([1, 2, 3]),
        ListNode.fromList([1, 4, 5]),
        ListNode.fromList([3, 6])
    ]))

if __name__ == "__main__":
    main()
