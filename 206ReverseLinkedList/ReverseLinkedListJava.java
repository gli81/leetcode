

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


class ListNode {
    int val;
    ListNode next;


    ListNode(){}

    ListNode(int val){this.val = val;}

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
