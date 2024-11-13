

import node_structure.TreeNode;
import java.util.Queue;
import java.util.LinkedList;

public class MinimumDepthofBinaryTreeJava {
    public int minDepth(TreeNode root) {
        if (null == root) return 0;
        int ans = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode cur = null;
        while (!q.isEmpty()) {
            int qsize = q.size();
            for (int i = 0; i < qsize; ++i) {
                cur = q.poll();
                if (null == cur.left && null == cur.right) return ans;
                if (null != cur.left) q.add(cur.left);
                if (null != cur.right) q.add(cur.right);
            }
            ans++;
        }
        return -1;
    }


    public static void main(String[] args) {
        MinimumDepthofBinaryTreeJava test =
            new MinimumDepthofBinaryTreeJava();
        System.out.println(
            test.minDepth(
                TreeNode.fromList(new Integer[]{3, 9, 20, null, null, 15, 7})
            )
        );
    }
}
