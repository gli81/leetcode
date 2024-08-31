

import node_structure.ListNode;

public class RotateListJava {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        // TODO find new start
        int len_list = 1;
        ListNode current = head;
        while (null != current.next) {
            len_list++;
            current = current.next;
        }
        int real_move = k % len_list;
        if (real_move == 0) return head;
        int find_it = len_list - real_move;
        ListNode new_start = head;
        for (int i = 0; i < find_it - 1; i++) {
            new_start = new_start.next;
        }
        ListNode new_start_ = new_start.next;
        // TODO set new tail's next: None
        new_start.next = null;
        // TODO set old tail's next: head
        current.next = head;
        return new_start_;
    }

    public static void main(String[] args) {
        RotateListJava test = new RotateListJava();
        ListNode test1 = new ListNode(1,
                        new ListNode(2, 
                        new ListNode(3,
                        new ListNode(4,
                        new ListNode(5, null)))));
        ListNode test2 = new ListNode(1,
                        new ListNode(2, 
                        new ListNode(3, null)));
        System.out.println(test.rotateRight(test1, 2));
        System.out.println(
            test.rotateRight(test2, 4)
        );

        // System.out.println(test1);
    }
}
