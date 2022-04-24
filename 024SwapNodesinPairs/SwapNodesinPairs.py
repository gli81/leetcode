# -*- coding: utf-8 -*-

from typing import Optional

class ListNode:
    def __init__(self, val: int = 0, next = None):
        self.val = val
        self.next = next
    def __str__(self):
        value = f"{self.val}"
        temp = self
        while temp.next != None:
            value = value + ", "
            temp = temp.next
            value = value + f"{temp.val}"
        return value

class SwapNodesinPairs:
    def swapPairs1(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        point = dummy
        while point.next != None and point.next.next != None:
            # print(dummy)
            tmp1 = point.next
            # print(dummy)
            tmp2 = point.next.next
            # print(dummy)
            point.next = tmp2
            # print(dummy)
            tmp1.next = tmp2.next
            # print(dummy)
            tmp2.next = tmp1
            # print(dummy)
            point = point.next.next
            # print(dummy)
        return dummy.next




def main():
    # print(ListNode(1,
    #     ListNode(2, None)))
    print(SwapNodesinPairs().swapPairs1(
        ListNode(1,
            ListNode(2,
                ListNode(3,
                    ListNode(4, None))))))


if __name__ == "__main__":
    main()
