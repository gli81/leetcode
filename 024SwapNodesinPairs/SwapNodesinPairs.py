# -*- coding: utf-8 -*-

from typing import Optional
import os
import sys
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from node_structure.ListNode import ListNode

class SwapNodesinPairs:
    def swapPairs1(self, head: "Optional[ListNode]") -> "Optional[ListNode]":
        dummy = ListNode(0, head)
        point = dummy
        while point.next is not None and point.next.next is not None:
            # print(dummy)
            tmp1 = point.next
            # print(dummy)
            tmp2 = point.next.next
            # print(dummy)
            point.next = tmp2
            # print(dummy)
            tmp1.next = tmp2.next
            # print(dummy)
            tmp2.next = tmp1
            # print(dummy)
            point = point.next.next
            # print(dummy)
        return dummy.next


def main():
    print(SwapNodesinPairs().swapPairs1(ListNode.fromList([1, 2, 3, 4])))

if __name__ == "__main__":
    main()
