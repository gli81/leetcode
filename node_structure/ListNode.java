package node_structure;

public class ListNode {
    public int val;
    public ListNode next;


    public ListNode(){}

    public ListNode(int val){this.val = val;}

    public ListNode(int val, ListNode next) {
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

    public static ListNode fromList(int[] lst) {
        if (lst.length == 0) return null;
        ListNode ans = new ListNode(lst[0]);
        ListNode cur = ans;
        for (int i = 1; i < lst.length; ++i) {
            cur.next = new ListNode(lst[i]);
            cur = cur.next;
        }
        return ans;
    }
}
