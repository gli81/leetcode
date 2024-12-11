# -*- coding: utf-8 -*-

import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from node_structure.ListNode import ListNode
from typing import Optional

class RemoveNthNodeFromEndofList:
    def removeNthFromEnd2(
        self, head: "Optional[ListNode]", n: "int"
    ) -> "Optional[ListNode]":
        left = right = head
        ## set distance between left and right to n
        ## remove the nth element from the end
        ## need to change the n+1th element from the end
        ## the node we change is n nodes before the last node
        for i in range(n):
            right = right.next
        ## move left and right together
        if right is None:
            return head.next
        while right.next is not None:
            left = left.next
            right = right.next
        ## right is at the end of the LinkNode now, let's change left.next
        left.next = left.next.next
        # print(left, right)
        return head


def main():
    test = RemoveNthNodeFromEndofList()
    print(test.removeNthFromEnd2(
        ListNode.fromList([0, 1, 2, 3, 4, 5, 6, 7, 8, 9]), 2
    ))
    print(test.removeNthFromEnd2(
        ListNode.fromList([0, 2]), 2
    ))

if __name__ == "__main__":
    main()
