# -*- coding:utf-8 -*-

from typing import Optional
import os
import sys
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from node_structure.ListNode import ListNode

class RotateList:
    def rotateRight(
        self,
        head: "Optional[ListNode]",
        k: "int"
    ) -> "Optional[ListNode]":
        if head is None: return head
        ## TODO find new start
        len_list = 1
        current = head
        while current.next is not None:
            len_list += 1
            current = current.next
        # print(len_list)
        real_move = k % len_list
        # print(f"real move: {real_move}")
        if real_move == 0: return head
        find_it = len_list - real_move
        # print(find_it)
        new_start = head
        for i in range(find_it - 1):
            new_start = new_start.next
        # print(new_start)
        new_start_ = new_start.next
        ## TODO set new tail's next: None
        new_start.next = None
        ## TODO set old tail's next: old head
        current.next = head
        return new_start_


def main():
    test = RotateList()
    test1: "Optional[ListNode]" = ListNode.fromList([1, 2, 3, 4, 5])
    test2: "Optional[ListNode]" = ListNode.fromList([0, 1, 2])
    # print(test1)
    # print(ListNode(1, None))
    print(test.rotateRight(test1, 2))
    print(test.rotateRight(test2, 4))


if __name__ == "__main__":
    main()
