# -*- coding: utf-8 -*-

from typing import Optional

class CopyLinkedListwithRandomPointer:
    def copyRandomList1(self, head: "Optional[Node]") -> "Optional[Node]":
        if not head: return None
        ans = Node(head.val)
        d = {head: ans}
        cur = head
        while cur.next:
            cur = cur.next
            d[cur] = Node(cur.val)
        cur = head
        while cur:
            d[cur].next = d[cur.next] if cur.next in d else None
            d[cur].random = d[cur.random] if cur.random in d else None
            cur = cur.next
        return d[head]


class Node:
    def __init__(self, val: "int", next: "Node"=None, random: "Node"=None):
        self.val = val
        self.next = next
        self.random = random


def main():
    test = CopyLinkedListwithRandomPointer()
    print(test.copyRandomList1(
        Node()
    ))

if __name__ == "__main__":
    main()
