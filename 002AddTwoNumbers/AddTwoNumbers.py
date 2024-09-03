# -*- coding: utf-8 -*-

import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from node_structure.ListNode import ListNode
from typing import Optional


class AddTwoNumbers:
    def addTwoNum1(
        self,
        l1 : "Optional[ListNode]",
        l2 : "Optional[ListNode]"
    ) -> "Optional[ListNode]":
        p = l1
        q = l2
        rslt = ListNode()
        up = 0
        current = rslt
        while(p != None or q != None):
            x = 0 if p == None else p.val
            y = 0 if q == None else q.val
            summ = x + y + up
            up = summ // 10
            cur = summ % 10
            current.next = ListNode(cur)
            current = current.next
            if p != None: p = p.next
            if q != None: q = q.next
        if (up == 1):
            current.next = ListNode(1)
        return rslt.next
    
    def addTwoNum2(
        self,
        l1 : "Optional[ListNode]",
        l2 : "Optional[ListNode]"
    ) -> "Optional[ListNode]":
        ans = ListNode()
        cur = ans
        one_more = 0
        while l1 and l2:
            cur.val = (l1.val + l2.val + one_more) % 10 
            one_more = (l1.val + l2.val + one_more) // 10
            if l1.next or l2.next:
                cur.next = ListNode()
                cur = cur.next
            l1 = l1.next
            l2 = l2.next
        while l1: ## but l2 is null
            cur.val = (l1.val + one_more) % 10
            one_more = (l1.val + one_more) // 10
            if l1.next:
                cur.next = ListNode()
                cur = cur.next
            l1 = l1.next
        while l2: ## but l1 is null
            cur.val = (l2.val + one_more) % 10
            one_more = (l2.val + one_more) // 10
            if l2.next:
                cur.next = ListNode()
                cur = cur.next
            l2 = l2.next
        if one_more:
            cur.next = ListNode(1, None)
        return ans


def main():
    test = AddTwoNumbers()
    test1 = ListNode.fromList([7, 8, 9])
    test2 = ListNode.fromList([3, 3, 5])
    print(test.addTwoNum2(test1, test2))
    test3 = ListNode.fromList([2, 4, 9])
    test4 = ListNode.fromList([5, 6, 4, 9])
    print(test.addTwoNum2(test3, test4))

if __name__ == "__main__":
    main()
