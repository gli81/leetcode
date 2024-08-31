import node_structure.*;

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

    // static class ListNode {
    //     int val;
    //     ListNode next;
    //     ListNode() {}
    //     ListNode(int val) {this.val = val;}
    //     ListNode(int val, ListNode next) {this.val = val; this.next = next;}
    //     @Override
    //     public String toString(){
    //         String value = this.val + "";
    //         ListNode tmp = this;
    //         while (tmp.next != null) {
    //             value = value + ", ";
    //             tmp = tmp.next;
    //             value = value + tmp.val;
    //         }
    //         return value;
    //     }
    // }
}