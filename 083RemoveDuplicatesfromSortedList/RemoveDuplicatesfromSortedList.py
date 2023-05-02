# -*- coding: utf -8-*-

from typing import Optional

class RemoveDuplicatesfromSortedList:
    def deleteDuplicates(self, head: "ListNode") \
                            -> "Optional[ListNode]":
        # print(f"head: {head}")
        cur = head
        pre = ListNode(0, head)
        ans = pre
        while cur and cur.next:
            eq = False
            while cur.next and cur.val == cur.next.val:
                cur = cur.next
                eq = True
            if eq:
                ## a series of duplicates
                ## set pre.next = cur.next
                pre.next = cur.next
            else:
                ## push pre forward to the element before
                ## next series of duplicates
                pre = cur
            ## traversing
            cur = cur.next
            # print(head)
        return ans.next

        

class ListNode:
    def __init__(self, val = 0, next = None):
        self.val = val
        self.next = next
    
    def __str__(self):
        ans = '['
        ans += str(self.val)
        cur = self
        while cur.next:
            cur = cur.next
            ans = ans + ", " + str(cur.val)
        ans += ']'
        return ans

def main():
    test = RemoveDuplicatesfromSortedListII()
    print(test.deleteDuplicates(ListNode(1,
                                ListNode(2,
                                ListNode(3,
                                ListNode(3,
                                ListNode(4,
                                ListNode(4,
                                ListNode(5)))))))))
    print(test.deleteDuplicates(ListNode(1,
                                ListNode(1,
                                ListNode(3,
                                ListNode(3,
                                ListNode(4,
                                ListNode(4,
                                ListNode(5)))))))))

if __name__ == "__main__":
    main()
