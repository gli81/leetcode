

import node_structure.TreeNode;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

public class SerializeandDeserializeBinaryTreeJava {
    public String serialize(TreeNode root) {
        // LinkedList allows null element, ArrayDeque doesn't
        if (null == root) return "";
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        int level = 0;
        if (null != root) q.add(root);
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
        String ans = "" + root.val;
        q.add(root.left);
        q.add(root.right);
        int cur_level = 1;
        while (!q.isEmpty() && cur_level < level) {
            int qsize = q.size();
            for (int i = 0; i < qsize; ++i) {
                cur = q.poll();
                if (null == cur) {
                    ans += "@null";
                    q.add(null);
                    q.add(null);
                } else {
                    ans += "@" + cur.val;
                    q.add(cur.left);
                    q.add(cur.right);
                }
            }
            cur_level++;
        }
        return ans;
    }

    public TreeNode deserialize(String data) {
        /**
         * exceed time limit
         */
        if (data.equals("")) return null;
        String[] lst = data.split("@");
        // System.out.println(Arrays.toString(lst));
        int n = lst.length;
        if (n == 0) return null;
        TreeNode[] ans = new TreeNode[n];
        ans[0] = lst[0].equals("null") ? null : new TreeNode(Integer.parseInt(lst[0]));
        // System.out.println(ans[0]);
        for (int i = 1; i < n; ++i) {
            if (!lst[i].equals("null")) {
                // if (i == 3) System.out.println(lst[i].equals("null"));
                if (ans[(i - 1) / 2] != null) {
                    ans[i] = new TreeNode(Integer.parseInt(lst[i]));
                    if (i % 2 == 1) ans[(i - 1) / 2].left = ans[i];
                    else ans[(i - 1) / 2].right = ans[i];
                } else {
                    // System.out.println(i);
                    return null;
                }
            }
        }
        return ans[0];
    }


    public static void main(String[] args) {
        SerializeandDeserializeBinaryTreeJava test =
            new SerializeandDeserializeBinaryTreeJava();
        TreeNode test1 = TreeNode.fromList(
            new Integer[]{1, 2, 3, null, null, 4, 5}
        );
        String ser1 = test.serialize(test1);
        System.out.println(ser1);
        System.out.println("=========");
        System.out.println(test.deserialize(ser1));
    }
}
