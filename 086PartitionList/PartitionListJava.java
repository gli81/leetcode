

public class PartitionListJava {
    public ListNode partition(ListNode head, int x) {
        ListNode min_head, max_head, min_, max_;
        min_head = new ListNode(0);
        min_ = min_head;
        max_head = new ListNode(0);
        max_ = max_head;
        // traverse the thing
        while (head != null) {
            
        }
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