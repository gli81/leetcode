

import node_structure.ListNode;
import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleDetectionJava {
    public boolean hasCycle1(ListNode head) {
        ListNode cur = head;
        Set<ListNode> s = new HashSet<>();
        while (null != cur) {
            if (s.contains(cur)) {
                return true;
            } else {
                s.add(cur);
            }
            cur = cur.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        slow = slow.next;
        fast = fast.next;
        if (null == fast) return false;
        fast = fast.next;
        while (null != slow && null != fast && null != fast.next && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow == fast) return true;
        return false;
    }


    public static void main(String[] args) {
        LinkedListCycleDetectionJava test =
            new LinkedListCycleDetectionJava();
        // System.out.println(
        //     test.hasCycle2(ListNode.fromList(new int[] {2, 5, 3, 7, 6}))
        // );
        System.out.println(
            test.hasCycle2(ListNode.fromList(new int[] {1}))
        );
    }
}