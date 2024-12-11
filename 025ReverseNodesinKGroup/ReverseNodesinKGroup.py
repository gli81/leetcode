# -*- coding: utf-8 -*-

import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from node_structure.ListNode import ListNode

class ReverseNodesinKGroup:
    def reverseKGroup1(self, head: "ListNode", k: "int") -> "ListNode":
        if k == 1: return head
        dummy = ListNode(0, head)
        sub_head = head
        tail = dummy
        to_null = head
        while sub_head:
            i = 1
            ## find end of current group
            while i < k:
                if not to_null.next:
                    return dummy.next
                to_null = to_null.next
                i += 1
            tmp = to_null.next
            to_null.next = None
            ## reverse current group
            cur = sub_head.next
            sub_head.next = tmp
            while cur.next:
                tmp = cur.next
                cur.next = sub_head
                sub_head = cur
                cur = tmp
            ## one more iter to deal with last node
            cur.next = sub_head
            ## set up for next iter
            tail_tmp = tail.next
            tail.next = cur
            tail = tail_tmp
            to_null = sub_head = tail.next
        return dummy.next


def main():
    test = ReverseNodesinKGroup()
    print(test.reverseKGroup1(
        ListNode.fromList([1, 2, 3, 4, 5, 6]), 3
    ))

if __name__ == "__main__":
    main()
