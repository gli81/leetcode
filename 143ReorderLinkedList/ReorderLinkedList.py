# -*- coding: utf-8 -*-

from typing import Optional
import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from node_structure.ListNode import ListNode


class ReorderLinkedList:
    def reorderList3(self, head: "Optional[ListNode]") -> "None":
        if not head or not head.next: return
        ## split linkedlist into two halves
        ## find mid point first
        l = head
        r = head
        while r.next and r.next.next:
            l = l.next
            r = r.next.next
        ## move l one more to ensure same length for even length
        ## first half have one more for odd length
        l = l.next
        ## reverse second half
        if l.next: ## if second half has more than one
            cur = l.next
            l.next = None
            while cur.next:
                tmp = cur.next
                cur.next = l
                l = cur
                cur = tmp
            cur.next = l
        else:
            cur = l
        ## merge two halves
        ans = head
        while cur.next:
            tmp = ans.next
            ans.next = cur
            ans = tmp
            tmp = cur.next
            cur.next = ans
            cur = tmp
        tmp = ans.next
        ans.next = cur
        cur.next = tmp
        ## avoid circle
        tmp.next = None
    

def main():
    test = ReorderLinkedList()
    test1 = ListNode.fromList([1, 2, 3, 4, 5])
    test.reorderList3(test1)
    print(test1)
    test2 = ListNode.fromList([1, 2, 3, 4, 5, 6])
    test.reorderList3(test2)
    print(test2)
    test3 = ListNode.fromList([1, 2, 3])
    test.reorderList3(test3)
    print(test3)

if __name__ == "__main__":
    main()
