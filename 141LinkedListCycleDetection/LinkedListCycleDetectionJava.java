

import node_structure.ListNode;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LinkedListCycleDetectionJava {
    public boolean hasCycle(ListNode head) {
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


    public static void main(String[] args) {
        LinkedListCycleDetectionJava test =
            new LinkedListCycleDetectionJava();
        System.out.println(
            test.hasCycle(ListNode.fromList(new int[] {2, 5, 3, 7, 6}))
        );
    }
}