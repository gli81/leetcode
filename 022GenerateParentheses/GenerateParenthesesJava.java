

public class MergeTwoSortedListsJava {
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        ListNode h = new ListNode(0, null);
        ListNode ans = h;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                h.next = l1;
                l1 = l1.next;
                h = h.next;
            } else {
                h.next = l2;
                l2 = l2.next;
                h = h.next;
            }
        }
        if (l2 == null) {
            h.next = l1;
        }
        if (l1 == null) {
            h.next = l2;
        }
        return ans.next;
    }

    public static void main(String[] args) {
        System.out.println("懒子从来不写测试");
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {this.val = val; this.next = next;}
        @Override
        public String toString(){
            String value = this.val + "";
            ListNode tmp = this;
            while (tmp.next != null) {
                value = value + ", ";
                tmp = tmp.next;
                value = value + tmp.val;
            }
            return value;
        }
    }
}