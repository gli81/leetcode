# -*- coding: utf -8-*-

class PartitionList:
    def partition(self, head: "ListNode", x: "int") -> "ListNode":
        pass


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
    print(test.partition())
    print(test.partition())

if __name__ == "__main__":
    main()
