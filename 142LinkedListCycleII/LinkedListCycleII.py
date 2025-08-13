# -*- coding: utf-8 -*-

import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from node_structure.ListNode import ListNode
from typing import Optional

class LinkedListCycleII:
    def detectCycle1(self, head: Optional[ListNode]) -> Optional[ListNode]:
        s = set()
        cur = head
        while cur is not None:
            if cur in s:
                return cur
            else:
                s.add(cur)
            cur = cur.next
        return None

    def detectCycle2(self, head: Optional[ListNode]) -> Optional[ListNode]:
        """
        two pointers
        """
        if not head: return None
        slow = fast = head
        slow = slow.next
        fast = fast.next
        if not fast: return None
        fast = fast.next
        while slow and fast and fast.next and slow != fast:
            slow = slow.next
            fast = fast.next.next
        if slow == fast:
            ## a = dist from head to cycle start
            ## b = dist from cycle start to meeting point
            ## c = dist from meeting point to cycle start
            ## a + n(b + c) + b = 2(a + b)
            ## dist fast travelled always 2x dist slow travelled
            ## a = c + (n - 1) (b + c)
            ## b + c can be ignored cuz just going in circles
            temp = head
            while temp != slow:
                temp = temp.next
                slow = slow.next
            return temp
        return None


def main():
    test = LinkedListCycleII()
    print(test.detectCycle2(
        ListNode.fromList([1, 2, 5, 3, 2])
    ))
    print(test.detectCycle2(
        ListNode.fromList([1, 2, 3, 4, 5, 6, 7, 8])
    ))

if __name__ == "__main__":
    main()
