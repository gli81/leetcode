
import node_structure.ListNode;

public class MergeKSortedLinkedListJava {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0 || null == lists) return null;
        int interval = 1;
        while (interval < n) {
            // interesting loop
            for (int i = 0; i < n - interval; i += (2 * interval)) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode cur = ans;
        while (null != l1 && null != l2) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if (null != l1) {
            cur.next = l1;
        }
        if (null != l2) {
            cur.next = l2;
        }
        return ans.next;
    }

    private void testInterval(int n) {
        int interval = 1;
        while (interval < n) {
            for (int i = 0; i < n - interval; i += 2 * interval) {
                System.out.println(i + ", " + (i + interval));
            }
            System.out.println("==============================");
            interval *= 2;
        }
    }


    public static void main(String[] args) {
        MergeKSortedLinkedListJava test = new MergeKSortedLinkedListJava();
        System.out.println(
            test.mergeKLists(new ListNode[] {
                ListNode.fromList(new int[]{1, 2, 4}),
                ListNode.fromList(new int[]{1, 3, 5}),
                ListNode.fromList(new int[]{3, 6})
            })
        );
        test.testInterval(8);;
        test.testInterval(7);;
    }
}
