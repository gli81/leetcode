

public class ReverseLinkedListIIJava {
    public ListNode reverseBetween(ListNode head,
                                   int left,
                                   int right) {
        return null;
    }


    public static void main(String[] args) {
        ReverseLinkedListIIJava test = 
                                new ReverseLinkedListIIJava();
        System.out.println(
            test.reverseBetween(new ListNode(1, 
                                             new ListNode(2,
                                             new ListNode(3,
                                             new ListNode(4,
                                             new ListNode(5)
                                             )))),
                                0, 0)
        );
    }
}


class ListNode {
    int val;
    ListNode next;


    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    @Override
    public String toString() {
        String ans = "[" + this.val;
        ListNode cur = this;
        while (cur != null && cur.next != null) {
            ans = ans + ", " + cur.next.val;
            cur = cur.next;
        }
        ans += "]";
        return ans;
    }
}