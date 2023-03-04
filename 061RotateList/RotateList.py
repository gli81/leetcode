# -*- coding:utf-8 -*-

from typing import Optional

class RotateList:
    def rotateRight(self, head: "Optional[ListNode]",
                    k: "int") -> "Optional[ListNode]":
        if head == None: return head
        ## TODO find new start
        len_list = 1
        current = head
        while None != current.next:
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
    test1: "Optional[ListNode]" = ListNode(1, 
                                        ListNode(2,
                                        ListNode(3,
                                        ListNode(4,
                                        ListNode(5, None)))))
    test2: "Optional[ListNode]" = ListNode(0, 
                                        ListNode(1,
                                        ListNode(2, None)))
    # print(test1)
    # print(ListNode(1, None))
    print(test.rotateRight(test1, 2))
    print(test.rotateRight(test2, 4))


class ListNode:
    def __init__(self, val: "int"=0,
                next: "Optional[ListNode]"=None):
        self.val = val
        self.next = next
    
    def __str__(self):
        ans = []
        cur = self
        # cur_next = self.next
        while cur.next != None:
            ans.append(cur.val)
            cur = cur.next
        ans.append(cur.val)
        return str(ans)


if __name__ == "__main__":
    main()
