

import node_structure.ListNode;

public class AddTwoNumbersJava {
    public ListNode addTwoNum1(
        ListNode l1, ListNode l2
    ) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode rslt = new ListNode();

        int up = 0;
        int cur = 0;
        int sum = 0;
        ListNode current = rslt;
        while(p != null || q != null) {
            sum = (p == null ? 0 : p.val) +
                    (q == null ? 0 : q.val) + up;
            up = sum / 10;
            cur = sum % 10;
            current.next = new ListNode(cur);
            current = current.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (up == 1) {
            current.next = new ListNode(1);
        }
        return rslt.next;
    }
    
    public ListNode addTwoNum2(
        ListNode l1, ListNode l2
    ) {
        ListNode ans = new ListNode();
        ListNode cur = ans;
        int one_more = 0;
        while (null != l1 && null != l2) {
            cur.val = (l1.val + l2.val + one_more) % 10;
            one_more = (l1.val + l2.val + one_more) / 10;
            if (null != l1.next || null != l2.next) {
                cur.next = new ListNode();
                cur = cur.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        // deal with different length
        while (null != l1) {
            cur.val = (l1.val + one_more) % 10;
            one_more = (l1.val + one_more) / 10;
            if (null != l1.next) {
                cur.next = new ListNode();
                cur = cur.next;
            }
            l1 = l1.next;
        }
        while (null != l2) {
            cur.val = (l2.val + one_more) % 10;
            one_more = (l2.val + one_more) / 10;
            if (null != l2.next) {
                cur.next = new ListNode();
                cur = cur.next;
            }
            l2 = l2.next;
        }
        // deal with one_more
        if (one_more > 0) cur.next = new ListNode(1);
        return ans;
    }
    

    public static void main(String[] args) {
        ListNode test1 = ListNode.fromList(new int[]{7, 8, 9});
        ListNode test2 = ListNode.fromList(new int[]{5, 5, 3});
        AddTwoNumbersJava test = new AddTwoNumbersJava();
        System.out.println(test.addTwoNum2(test1, test2));
        ListNode test3 = ListNode.fromList(new int[]{2, 4, 9});
        ListNode test4 = ListNode.fromList(new int[]{5, 6, 3, 9});
        System.out.println(test.addTwoNum2(test3, test4));
    }
}
