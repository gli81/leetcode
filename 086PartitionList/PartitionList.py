# -*- coding: utf -8-*-

class PartitionList:
    def partition(self, head: "ListNode", x: "int") -> "ListNode":
        min_head: "ListNode" = ListNode(0)
        min_: "ListNode" = min_head
        max_head: "ListNode" = ListNode(0)
        max_: "ListNode" = max_head

        ## traverse the linked list
        while head:
            if head.val < x:
                min_.next = head
                min_ = min_.next
            else:
                max_.next = head
                max_ = max_.next
            head = head.next
        max_.next = None
        min_.next = max_head.next
        return min_head.next


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
    test = PartitionList()
    print(test.partition(ListNode(1,
                            ListNode(4,
                            ListNode(3,
                            ListNode(2,
                            ListNode(5,
                            ListNode(2)))))), 3)
    )
    # print(test.partition())

if __name__ == "__main__":
    main()
