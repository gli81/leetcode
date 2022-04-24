# -*- coding: utf-8 -*-

from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
    def __str__(self):
        value: str = f"{self.val}"
        tmp = self
        while tmp.next != None:
            value = value + ", "
            tmp = tmp.next
            value = value + f"{tmp.val}"
        return value


class MergeTwoSortedLists:
    def mergeTwoLists1(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        h = ListNode(0)
        ans = h
        while l1 != None and l2 != None:
            if l1.val < l2.val:
                h.next = l1
                h = h.next
                l1 = l1.next
            else: 
                h.next = l2
                h = h.next
                l2 = l2.next
        if l1 == None:
            h.next = l2
        if l2 == None:
            h.next = l1
        return ans.next

def main():
    print(MergeTwoSortedLists().mergeTwoLists1(
        ListNode(1,
            ListNode(2,
                ListNode(4, None))),
        ListNode(1,
            ListNode(3,
                ListNode(4, None)))))
    print(MergeTwoSortedLists().mergeTwoLists1(None, None))


if __name__ == "__main__":
    main()
