# -*- coding: utf-8 -*-

import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from node_structure import ListNode

class LinkedListCycleDetection:
    def hasCycle(self, head: "ListNode") -> "bool":
        s = set()
        cur = head
        while cur:
            if cur in s:
                return True
            else:
                s.add(cur)
            cur = cur.next
        return False


def main():
    test = LinkedListCycleDetection()
    print(test.hasCycle(
        ListNode.fromList([1, 2, 5, 3, 2])
    ))

if __name__ == "__main__":
    main()
