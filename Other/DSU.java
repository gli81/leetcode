
public class DSU<T> {
    public DSU() {}


    public Node<T> makeSet(T value) {
        Node<T> node = new Node<T>(null, 0, value);
        node.parent = node;
        return node;
    }


    public Node<T> find(Node<T> node) {
        while (node != node.parent) {
            node = node.parent;
        }
        return node;
    }

    public void union(Node<T> a, Node<T> b) {
        // find roots
        Node<T> ra = find(a);
        Node<T> rb = find(b);
        if (ra == rb) {
            return; // already in the same set
        }
        // union by height
        if (ra.height < rb.height) {
            ra.parent = rb;
        } else if (ra.height > rb.height) {
            rb.parent = ra;
        } else {
            // same height
            ra.parent = rb;
            rb.height++;
        }
    }


    public static void main(String[] args) {
        int[] in = {1, 2, 3, 4, 5};
        DSU<Integer> dsu = new DSU<>();
        Node<Integer>[] nodes = new Node[in.length];
        for (int i = 0; i < in.length; ++i) {
            nodes[i] = dsu.makeSet(in[i]);
        }
        dsu.union(nodes[0], nodes[1]);
        dsu.union(nodes[1], nodes[2]);
        dsu.union(nodes[3], nodes[4]);
        dsu.union(nodes[2], nodes[3]);
        for (Node<Integer> node : nodes) {
            Node<Integer> root = dsu.find(node);
            System.out.println(
                "Value: " + node.value + ", Parent: " + node.parent.value
                + ", Root: " + root.value + ", Height: "
                + root.height);
        }
    }
}

class Node<T> {
    Node<T> parent;
    int height;
    T value;


    public Node(Node<T> parent, int height, T value) {
        this.parent = parent;
        this.height = height;
        this.value = value;
    }
}