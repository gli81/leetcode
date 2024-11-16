

import node_structure.TreeNode;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

public class SerializeandDeserializeBinaryTreeJava {
    public String serialize1(TreeNode root) {
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

    public String serialize2(TreeNode root) {
        if (null == root) return "";
        // LinkedList allows null element, ArrayDeque doesn't
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        StringBuilder ans = new StringBuilder();
        ans.append(root.val);
        q.add(root.left);
        q.add(root.right);
        TreeNode cur = null;
        while (!q.isEmpty()) {
            cur = q.poll();
            if (null == cur) {
                ans.append("@null");
            } else {
                ans.append("@").append(cur.val);
                q.add(cur.left);
                q.add(cur.right);
            }
        }
        return ans.toString();
    }

    public TreeNode deserialize1(String data) {
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

    public TreeNode deserialize2(String data) {
        if (data.equals("")) return null;
        String[] lst = data.split("@");
        TreeNode ans = new TreeNode(Integer.parseInt(lst[0]));
        Queue<TreeNode> parents = new LinkedList<>();
        TreeNode parent = ans;
        TreeNode cur = null;
        boolean isLeft = true;
        for (int i = 1; i < lst.length; ++i) {
            if (lst[i].equals("null")) {
                cur = null;
            } else {
                cur = new TreeNode(Integer.parseInt(lst[i]));
            }
            if (isLeft) {
                parent.left = cur;
            } else {
                parent.right = cur;
            }
            if (null != cur) {
                parents.add(cur);
            }
            isLeft = !isLeft;
            if (isLeft) {
                parent = parents.poll();
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        SerializeandDeserializeBinaryTreeJava test =
            new SerializeandDeserializeBinaryTreeJava();
        TreeNode test1 = TreeNode.fromList(
            new Integer[]{1, 2, 3, null, null, 4, 5}
        );
        String ser1 = test.serialize1(test1);
        String ser11 = test.serialize2(test1);
        System.out.println(ser1);
        System.out.println(ser11);
        System.out.println("=========");
        System.out.println(test.deserialize1(ser1));
        System.out.println(test.deserialize2(ser11));
        TreeNode test2 = TreeNode.fromList(
            new Integer[]{1, 2, 3, null, null, 4, 5, null, null, null, null,6, 7}
            );
        String ser2 = test.serialize1(test2);
        String ser22 = test.serialize2(test2);
        System.out.println(ser2);
        System.out.println(ser22);
        System.out.println("=========");
        System.out.println(test.deserialize1(ser2));
        System.out.println(test.deserialize2(ser22));
    }
}
