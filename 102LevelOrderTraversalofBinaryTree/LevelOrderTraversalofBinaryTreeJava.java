

import node_structure.TreeNode;
import java.util.List;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
// import java.util.stream.Stream;

public class LevelOrderTraversalofBinaryTreeJava {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (null == root) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<TreeNode>();
        q.add(root);
        List<Integer> cur;
        // ans.add(Stream.of(root.val).toList());
        // System.out.println(ans);
        TreeNode tmp;
        while (!q.isEmpty()) {
            int qsize = q.size();
            cur = new ArrayList<>();
            for (int i = 0; i < qsize; ++i) {
                tmp = q.poll();
                cur.add(tmp.val);
                if (null != tmp.left) {
                    q.add(tmp.left);
                }
                if (null != tmp.right) {
                    q.add(tmp.right);
                }
            }
            ans.add(cur);
        }
        return ans;
    }

    
    public static void main(String[] args) {
        LevelOrderTraversalofBinaryTreeJava test = 
            new LevelOrderTraversalofBinaryTreeJava();
        System.out.println(
            test.levelOrder(
                TreeNode.fromList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8})
            )
        );
    }
}
