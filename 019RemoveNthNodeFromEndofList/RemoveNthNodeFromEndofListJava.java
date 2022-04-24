

public class RemoveNthNodeFromEndofListJava {
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode left = head;
        ListNode right = head;
        for (int i = 0; i < n; i++) {right = right.next;}
        if (right == null) {return head.next;}
        while(right.next != null) {
            right = right.next;
            left = left.next;
        }
        // delete node
        left.next = left.next.next;
        return head;
    }
    public static void main(String[] args) {
        
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {this.val = val; this.next = next;}
    }
}
