

import java.util.Map;
import java.util.HashMap;


public class LRUCacheJava {
    int cap;
    Map<Integer, Node> cache;
    Node l;
    Node r;


    public LRUCacheJava(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.l = new Node(0, 0);
        this.r = new Node(0, 0);
        this.l.next = r; // LRU
        this.r.prev = l;
    }


    public int get(int key) {
        // System.out.print("In get ===> ");
        // printList();
        if (this.cache.containsKey(key)) {
            Node to_update = this.cache.get(key);
            // remove node from list
            to_update.prev.next = to_update.next;
            to_update.next.prev = to_update.prev;
            // insert node to right
            this.r.prev.next = to_update;
            to_update.prev = this.r.prev;
            this.r.prev = to_update;
            to_update.next = this.r;
            // System.out.println(to_update.prev);
            return to_update.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int val) {
        Node to_update;
        if (this.cache.containsKey(key)) {
            // remove node from list
            to_update = this.cache.get(key);
            to_update.prev.next = to_update.next;
            to_update.next.prev = to_update.prev;
        }
        to_update = new Node(key, val);
        // insert node to right
        this.r.prev.next = to_update;
        to_update.prev = this.r.prev;
        this.r.prev = to_update;
        to_update.next = this.r;
        this.cache.put(key, to_update);
        // check capacity
        if (this.cache.size() > this.cap) {
            Node lru = this.l.next;
            // remove from left
            this.l.next = lru.next;
            lru.next.prev = this.l;
            this.cache.remove(lru.key);
        }
    }

    private void printList() {
        Node cur = this.l.next;
        while (null != cur) {
            System.out.print("[" + cur.val + " " + cur.key + "]");
            if (cur.next != this.r) {
                System.out.print(", ");
            } else {break;}
            cur = cur.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        LRUCacheJava test = new LRUCacheJava(2);
        test.put(1, 1);
        test.put(2, 2);
        test.printList();
        test.get(1);
        test.printList();
        test.put(3, 3);
        System.out.println(test.cache);
        test.printList();
        System.out.println("LINE GET 1 ERROR");
        test.get(1);
        System.out.println(test.cache);
        test.printList();
        test.get(2);
        System.out.println(test.get(3));
        test.get(1);
        test.printList();
    }
}


class Node {
    int key;
    int val;
    Node prev;
    Node next;


    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }

    @Override
    public String toString() {
        return "<key: " + this.key + ", val: " + this.val + ", prev: " + this.prev.key + ", next: " + this.next.key + ">";
    }
}