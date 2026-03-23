

import node_structure.ListNode;

public class ReverseNodesinKGroupJava {
    public ListNode reverseKGroup1(ListNode head, int k) {
        if (k == 1) return head;
        ListNode dummy, sub_head, to_null, tail;
        tail = dummy = new ListNode(0, head);
        sub_head = to_null = head;
        while (null != sub_head) {
            int i = 1;
            // find end of current group
            while (i < k) {
                if (to_null.next == null) {
                    return dummy.next;
                }
                to_null = to_null.next;
                i++;
            }
            ListNode tmp = to_null.next;
            to_null.next = null;
            // reverse current group
            ListNode cur = sub_head.next;
            sub_head.next = tmp;
            while (null != cur.next) {
                tmp = cur.next;
                cur.next = sub_head;
                sub_head = cur;
                cur = tmp;
            }
            // one more iter to deal with last node in group
            cur.next = sub_head;
            // setup for next iter
            ListNode tail_tmp = tail.next;
            tail.next = cur;
            tail = tail_tmp;
            to_null = sub_head = tail.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ReverseNodesinKGroupJava test = new ReverseNodesinKGroupJava();
        System.out.println(
            test.reverseKGroup1(
                ListNode.fromList(new int[]{1, 2, 3, 4, 5, 6}), 3
            )
        );
    }
}
