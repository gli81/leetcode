

import node_structure.ListNode;

public class RemoveDuplicatesfromSortedListIIJava {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode pre = new ListNode(0, head);
        ListNode ans = pre;
        while (cur != null && cur.next != null) {
            boolean eq = false;
            while (cur.next != null && cur.next.val == cur.val) {
                eq = true;
                cur = cur.next;
            }
            if (eq) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return ans.next;
    }

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedListIIJava test = 
            new RemoveDuplicatesfromSortedListIIJava();
        System.out.println(test.deleteDuplicates(new ListNode(1,
                                new ListNode(2,
                                new ListNode(3,
                                new ListNode(3,
                                new ListNode(4,
                                new ListNode(4,
                                new ListNode(5)))))))));
    }
}
