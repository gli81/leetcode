# -*- coding: utf-8 -*-

import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from node_structure.ListNode import ListNode

class LinkedListCycleDetection:
    def hasCycle1(self, head: "ListNode") -> "bool":
        s = set()
        cur = head
        while cur:
            if cur in s:
                return True
            else:
                s.add(cur)
            cur = cur.next
        return False

    def hasCycle2(self, head: "ListNode") -> "bool":
        """
        two pointers
        """
        if not head: return False
        slow = fast = head
        slow = slow.next
        fast = fast.next
        if not fast: return False
        fast = fast.next
        while slow and fast and fast.next and slow != fast:
            slow = slow.next
            fast = fast.next.next
        return slow == fast


def main():
    test = LinkedListCycleDetection()
    print(test.hasCycle2(
        ListNode.fromList([1, 2, 5, 3, 2])
    ))
    print(test.hasCycle2(
        ListNode.fromList([1, 2, 3, 4, 5, 6, 7, 8])
    ))

if __name__ == "__main__":
    main()
