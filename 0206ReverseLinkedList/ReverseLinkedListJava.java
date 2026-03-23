

import node_structure.ListNode;

public class ReverseLinkedListJava {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head;
        while (null != cur) {
            ListNode nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        return prev;
    }

    
    public static void main(String[] args) {
        ReverseLinkedListJava test =
            new ReverseLinkedListJava();
    }
}
