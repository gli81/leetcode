

import node_structure.TreeNode;
import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class BinaryTreeRightSideViewJava {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (null == root) return ans;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        TreeNode cur;
        while (!q.isEmpty()) {
            int qsize = q.size();
            for (int i = 0; i < qsize; ++i) {
                cur = q.poll();
                if (null != cur.left) q.add(cur.left);
                if (null != cur.right) q.add(cur.right);
                if (i == qsize - 1) {
                    ans.add(cur.val);
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println("No test");
    }
}
