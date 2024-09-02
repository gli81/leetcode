

import java.util.HashMap;
import java.util.Map;

public class CopyLinkedListwithRandomPointerJava {
    public Node copyRandomList(Node head) {
        Map<Node, Node> d = new HashMap<>();
        Node cur = head;
        while (null != cur) {
            d.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (null != cur) {
            d.get(cur).next = d.getOrDefault(cur.next, null);
            d.get(cur).random = d.getOrDefault(cur.random, null);
            cur = cur.next;
        }
        return d.get(head);
    }


    public static void main(String[] args) {
        
    }
}

class Node {
    int val;
    Node next;
    Node random;


    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}