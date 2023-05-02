# -*- coding: utf -8-*-

from typing import Optional

class RemoveDuplicatesfromSortedList:
    def deleteDuplicates(self, head: "ListNode") \
                            -> "Optional[ListNode]":
        cur = head
        while cur and cur.next:
            if cur.next and cur.val == cur.next.val:
                cur.next = cur.next.next
            else:
                cur = cur.next
        return head

        
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
    test = RemoveDuplicatesfromSortedList()
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
