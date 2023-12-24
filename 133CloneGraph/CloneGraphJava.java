

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CloneGraphJava {
    public Node cloneGraph(Node node) {
        if (null == node) return null;
        HashMap<Integer, Node> visited = new HashMap<>();
        visited.put(node.val, new Node(
            node.val, new ArrayList<>()
        ));
        LinkedList<Node> q = new LinkedList<Node>();
        q.add(node);
        // bfs
        while (!q.isEmpty()) {
            Node n = q.remove();
            for (Node neighbor : n.neighbors) {
                if (!visited.containsKey(neighbor.val)) {
                    visited.put(neighbor.val, new Node(
                        neighbor.val, new ArrayList<>()
                    ));
                    q.add(neighbor);
                }
                visited.get(n.val).neighbors.add(
                    visited.get(neighbor.val)
                );
            }
        }
        return visited.get(node.val);
    }


    public static void main(String[] args) {
        // CloneGraphJava test = new CloneGraphJava();
        System.out.println("no test");
    }
}


class Node {
    public int val;
    public List<Node> neighbors;


    public Node() {
        this.val = 0;
        this.neighbors = new ArrayList<Node>();
    }

    public Node(int val) {
        this.val = val;
        this.neighbors = new ArrayList<Node>();
    }

    public Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}