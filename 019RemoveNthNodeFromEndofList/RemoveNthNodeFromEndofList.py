# -*- coding: utf-8 -*-

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
    def __str__(self):
        value: str = f"{self.val}"
        check: ListNode = self
        while check.next != None:
            value += str(f", {check.next.val}")
            check = check.next
        return value

class RemoveNthNodeFromEndofList:
    def removeNthFromEnd2(self, head: ListNode, n: int) -> ListNode:
        left = right = head
        ## set distance between left and right to n
        ## remove the nth element from the end, need to change the n+1th element from the end
        ## the node we change is n nodes before the last node
        for i in range(n):
            right = right.next
        ## move left and right together
        if right == None:
            return head.next
        while right.next != None:
            left = left.next
            right = right.next
        ## right is at the end of the LinkNode now, let's change left.next
        left.next = left.next.next
        
        # print(left, right)
        return head

def main():
    print(RemoveNthNodeFromEndofList().removeNthFromEnd2(
        ListNode(0,
        ListNode(1,
        ListNode(2,
        ListNode(3,
        ListNode(4,
        ListNode(5,
        ListNode(6,
        ListNode(7,
        ListNode(8,
        ListNode(9)))))))))), 2))
    print(RemoveNthNodeFromEndofList().removeNthFromEnd2(
        ListNode(0,
        ListNode(2)), 2))

if __name__ == "__main__":
    main()
