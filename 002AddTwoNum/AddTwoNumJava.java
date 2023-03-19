
public class AddTwoNumJava {
    public ListNode addTwoNum(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode rslt = new ListNode();

        int up = 0;
        int cur = 0;
        int sum = 0;
        ListNode current = rslt;
        while(p != null || q != null) {
            sum = (p == null ? 0 : p.val) +
                    (q == null ? 0 : q.val) + up;
            up = sum / 10;
            cur = sum % 10;
            current.next = new ListNode(cur);
            current = current.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (up == 1) {
            current.next = new ListNode(1);
        }
        return rslt.next;
    }
    public static void main(String[] args) {
        ListNode LN987 = new ListNode(7,
                                    new ListNode(8,
                                    new ListNode(9,
                                                null)));
        // System.out.println(a);
        // System.out.println(a.next);
        // System.out.println(a.next.next);
        ListNode LN355 = new ListNode(5,
                                    new ListNode(5,
                                    new ListNode(3,
                                            null)));

        AddTwoNumJava obj = new AddTwoNumJava();
        ListNode ans = obj.addTwoNum(LN987, LN355);
        System.out.println("" + ans + " " + ans.next +
                            " " + ans.next.next + " " +
                            ans.next.next.next);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
    @Override
    public String toString() {return "" + this.val;}
}