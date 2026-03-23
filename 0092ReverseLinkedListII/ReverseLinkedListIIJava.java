

public class ReverseLinkedListIIJava {
    public ListNode reverseBetween(ListNode head,
                                   int left,
                                   int right) {
        if (left == right) return head;
        // to facilitate border situation
        // introduce dummy as the head of the linked list
        ListNode dummy = new ListNode(0, head);
        int count = 1;
        ListNode left1, left2, pre;
        left1 = left2 = null;
        pre = dummy;
        while (true) {
            if (count == left) {
                left1 = pre;
                left2 = head;
            }
            // when head at left (count==left)
            // don't need to set left's next
            if (count > left && count <= right) {
                ListNode temp = head.next;
                head.next = pre;
                pre = head;
                head = temp;
                count++;
                continue; // skip the head=head.next thing
            }
            if (count > right) {
                left2.next = head;
                left1.next = pre;
                break;
            }
            // not in the range, normally traverse
            head = head.next;
            count++;
            pre = pre.next;

        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ReverseLinkedListIIJava test = 
                                new ReverseLinkedListIIJava();
        ListNode r1 = test.reverseBetween(new ListNode(1, 
                                             new ListNode(2,
                                             new ListNode(3,
                                             new ListNode(4,
                                             new ListNode(5)
                                             )))),
                                      2, 4);
        ListNode r2 = test.reverseBetween(new ListNode(3,
                                              new ListNode(5)),
                                     1, 2);
        System.out.println(r1);
        System.out.println(r2);
        // ListNode cur = r1;
        // while (null != cur) {
        //     System.out.println(cur.val);
        //     if (null != cur.next) {
        //         cur = cur.next;
        //     } else break;
        // }
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