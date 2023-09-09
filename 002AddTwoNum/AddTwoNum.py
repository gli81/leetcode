# -*- coding: utf-8 -*-

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
    def __str__(self):
        return str(self.val)

class AddTwoNum:
    def addTwoNum(self,
                  l1 : "ListNode",
                  l2 : "ListNode") -> "ListNode":
        p = l1
        q = l2
        rslt = ListNode()
        up = 0
        current = rslt
        while(p != None or q != None):
            x = 0 if p == None else p.val
            y = 0 if q == None else q.val
            summ = x + y + up
            up = summ // 10
            cur = summ % 10
            current.next = ListNode(cur)
            current = current.next
            if p != None: p = p.next
            if q != None: q = q.next
        if (up == 1):
            current.next = ListNode(1)
        return rslt.next


def main():
    LN987 = ListNode(7, ListNode(8, ListNode(9, None)))
    print(LN987)
    print(LN987.next)
    print(LN987.next.next)
    LN355 = ListNode(5, ListNode(5, ListNode(3, None)))

    ans = AddTwoNum().addTwoNum(LN987, LN355)
    print("")
    print("" + str(ans))
    print("" + str(ans) + " " + str(ans.next))
    print("" + str(ans) + " " + str(ans.next) + " "\
            + str(ans.next.next))
    print("" + str(ans) + " " + str(ans.next) + " "\
            + str(ans.next.next) + " " + str(ans.next.next.next))

if __name__ == "__main__":
    main()
