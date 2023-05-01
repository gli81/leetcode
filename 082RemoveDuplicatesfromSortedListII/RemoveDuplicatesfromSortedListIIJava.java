

public class RemoveDuplicatesfromSortedListIIJava {
    public ListNode deleteDuplicates(ListNode head) {
        return null;
    }

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedListIIJava test = 
            new RemoveDuplicatesfromSortedListIIJava();
        System.out.println(test);
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
}