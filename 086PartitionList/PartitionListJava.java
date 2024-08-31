

import node_structure.ListNode;

public class PartitionListJava {
    public ListNode partition(ListNode head, int x) {
        ListNode min_head, max_head, min_, max_;
        min_head = new ListNode(0);
        min_ = min_head;
        max_head = new ListNode(0);
        max_ = max_head;
        // traverse the thing
        while (head != null) {
            if (head.val < x) {
                min_.next = head;
                min_ = min_.next;
            } else {
                max_.next = head;
                max_ = max_.next;
            }
            head = head.next;
        }
        // put together
        min_.next = max_head.next;
        max_.next = null;
        return min_head.next;
    }
    
    public static void main(String[] args) {
        PartitionListJava test =
            new PartitionListJava();
        System.out.println(test.partition(new ListNode(1, 
                            new ListNode(4,
                            new ListNode(3,
                            new ListNode(2,
                            new ListNode(5,
                            new ListNode(2)))))), 3));
    }
}
