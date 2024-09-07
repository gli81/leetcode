package node_structure;

import java.util.Queue;
import java.util.LinkedList;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;


    public TreeNode(){};

    public TreeNode(int val) {this.val = val;}

    public TreeNode(
        int val,
        TreeNode left,
        TreeNode right
    ) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    
    @Override
    public String toString() {
        // LinkedList allows null element, ArrayDeque doesn't
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        int level = 0;
        if (null != this) q.add(this);
        TreeNode cur = null; 
        while (!q.isEmpty()) {
            int qsize = q.size();
            for (int i = 0; i < qsize; ++i) {
                cur = q.poll();
                if (null != cur.left) q.add(cur.left);
                if (null != cur.right) q.add(cur.right);
            }
            level++;
        }
        // q.clear(); // must be empty out of while
        String ans = "[" + this.val;
        q.add(this.left);
        q.add(this.right);
        int cur_level = 1;
        while (!q.isEmpty() && cur_level < level) {
            int qsize = q.size();
            for (int i = 0; i < qsize; ++i) {
                cur = q.poll();
                if (null == cur) {
                    ans += ", null";
                    q.add(null);
                    q.add(null);
                } else {
                    ans += ", " + cur.val;
                    q.add(cur.left);
                    q.add(cur.right);
                }
            }
            cur_level++;
        }
        ans += "]";
        return ans;
    }

    public static TreeNode fromList(Integer[] lst) {
        if (null == lst) return null;
        int n = lst.length;
        if (n == 0) return null;
        TreeNode[] ans = new TreeNode[n];
        ans[0] = lst[0] == null ? null : new TreeNode(lst[0]);
        for (int i = 1; i < n; ++i) {
            if (lst[i] != null){
                if (ans[(i - 1) / 2] != null) {
                    ans[i] = new TreeNode(lst[i]);
                    if (i % 2 == 1) {
                        ans[(i - 1) / 2].left = ans[i];
                    } else {
                        ans[(i - 1) / 2].right = ans[i];
                    }
                } else {
                    System.err.println("Invalid Input");
                    return null;
                }
            }
        }
        return ans[0];
    }
}
