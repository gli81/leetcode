

import node_structure.ListNode;

public class ReorderLinkedListJava {
    public void reorderList3(ListNode head) {
        // split linkedlist into two halves
        // find mid point first
        ListNode l, r;
        l = r = head;
        while (r.next != null && r.next.next != null) {
            l = l.next;
            r = r.next.next;
        }
        l = l.next;
        ListNode cur;
        ListNode tmp;
        // reverse second half
        if (null != l.next) {
            cur = l.next;
            l.next = null;
            while (null != cur.next) {
                tmp = cur.next;
                cur.next = l;
                l = cur;
                cur = tmp;
            }
            cur.next = l;
        } else {
            cur = l;
        }
        // merge two halves
        ListNode ans = head;
        while (null != cur.next) {
            tmp = ans.next;
            ans.next = cur;
            ans = tmp;
            tmp = cur.next;
            cur.next = ans;
            cur = tmp;
        }
        tmp = ans.next;
        ans.next = cur;
        cur.next = tmp;
        tmp.next = null;
    }


    public static void main(String[] args) {
        ReorderLinkedListJava test = new ReorderLinkedListJava();
        ListNode test1 = ListNode.fromList(new int[]{1, 2, 3, 4, 5});
        test.reorderList3(test1);
        System.out.println(test1);
    }
}