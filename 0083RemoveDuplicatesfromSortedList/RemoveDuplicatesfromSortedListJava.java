

import node_structure.ListNode;

public class RemoveDuplicatesfromSortedListJava {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == cur.val){
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedListJava test = 
            new RemoveDuplicatesfromSortedListJava();
        System.out.println(test.deleteDuplicates(new ListNode(1,
                                new ListNode(2,
                                new ListNode(3,
                                new ListNode(3,
                                new ListNode(4,
                                new ListNode(4,
                                new ListNode(5)))))))));
    }
}
