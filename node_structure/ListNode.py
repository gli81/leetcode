# -*- coding: utf-8 -*-

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def __str__(self):
        cur = self
        ans = []
        ans.append(cur.val)
        while cur.next:
            ans.append(cur.next.val)
            cur = cur.next
        return str(ans)

    @classmethod
    def fromList(cls, lst):
        if not lst: return None
        head = ListNode(lst[0])
        cur = head
        for val in lst[1:]:
            cur.next = ListNode(val, None)
            cur = cur.next
        return head
