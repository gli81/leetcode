
public class RotateListJava {

    public ListNode rotateRight(ListNode head, int k) {
        return null;
    }

    public static void main(String[] args) {
        RotateListJava test = new RotateListJava();
        ListNode test1 = new ListNode(1,
                        new ListNode(2, 
                        new ListNode(3,
                        new ListNode(4,
                        new ListNode(5, null)))));
        ListNode test2 = new ListNode(1,
                        new ListNode(2, 
                        new ListNode(3, null)));
        System.out.println(test.rotateRight(test1, 2));
        System.out.println(
            test.rotateRight(test2, 4)
        );

        // System.out.println(test1);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString(){
        String ans = "[" + this.val;
        ListNode cur_next = this.next;
        while (null != cur_next) {
            ans = ans + ", ";
            ans = ans + cur_next.val;
            cur_next = cur_next.next;
        }
        ans = ans + "]";
        return ans;
    }
}