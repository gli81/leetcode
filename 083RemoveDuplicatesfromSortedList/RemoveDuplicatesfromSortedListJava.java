

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