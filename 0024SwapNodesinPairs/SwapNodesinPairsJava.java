

import node_structure.ListNode;

public class SwapNodesinPairsJava {
    public ListNode swapNodes1(ListNode head){
        ListNode dummy = new ListNode(0, head);
        ListNode point = dummy;
        while (point.next != null && point.next.next != null) {
            ListNode tmp1 = point.next;
            ListNode tmp2 = point.next.next;
            point.next = tmp2;
            tmp1.next = tmp2.next;
            tmp2.next = tmp1;
            point = point.next.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(new SwapNodesinPairsJava().swapNodes1(
            new ListNode(1,
            new ListNode(2,
            new ListNode(3,
            new ListNode(4, null))))));
    }
}
