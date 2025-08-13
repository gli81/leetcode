# -*- coding: utf-8 -*-

import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from node_structure.ListNode import ListNode
from typing import Optional

class IntersectionOfTwoLinkedLists:
    def getIntersectionNode1(
        self, headA: ListNode, headB: ListNode
    ) -> Optional[ListNode]:
        """
        set
        """
        visited = set()
        p = headA
        while p is not None:
            visited.add(p)
            p = p.next
        p = headB
        while p is not None:
            if p in visited:
                return p
            p = p.next
        return None

    def getIntersectionNode2(
        self, headA: ListNode, headB: ListNode
    ) -> Optional[ListNode]:
        """
        two pointers cycle detection
        """
        pA = headA
        pB = headB
        while pA != pB:
            if pA is None and pB is None: return None
            if pA is not None:
                pA = pA.next
            else:
                pA = headB
            if pB is not None:
                pB = pB.next
            else:
                pB = headA
        return pA
