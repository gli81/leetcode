

import java.util.Queue;
import java.util.ArrayDeque;
import node_structure.TreeNode;

public class MaximumDepthofBinaryTreeJava {
    public int maxDepth1(TreeNode root) {
        if (null == root) return 0;
        return Math.max(
            maxDepth1(root.left), maxDepth1(root.right)
        ) + 1;
    }

    public int maxDepth2(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        int ans = 0;
        if (null != root) {
            q.add(root);
        }
        TreeNode cur = null;
        int qsize = 0;
        while (!q.isEmpty()) {
            qsize = q.size();
            for (int i = 0; i < qsize; ++i) {
                cur = q.poll();
                if (null != cur.left) q.add(cur.left);
                if (null != cur.right) q.add(cur.right);
            }
            ans++;
        }
        return ans;
    }


    public static void main(String[] args) {
        MaximumDepthofBinaryTreeJava test = new MaximumDepthofBinaryTreeJava();
        System.out.println(test.maxDepth2(
            TreeNode.fromList(new Integer[]{1, null, 3, null, null, 6})
        ));
    }
}
