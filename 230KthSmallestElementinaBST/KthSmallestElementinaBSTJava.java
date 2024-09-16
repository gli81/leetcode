

import node_structure.TreeNode;
import java.util.Stack;

public class KthSmallestElementinaBSTJava {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        while (stk.size() != 0) {
            while (null != root.left) {
                stk.push(root.left);
                root = root.left;
            }
            root = stk.pop();
            if (--k == 0) return root.val;
            while (null == root.right && stk.size() > 0) {
                root = stk.pop();
                if (--k == 0) return root.val;
            }
            if (null != root.right) {
                stk.push(root.right);
                root = root.right;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        KthSmallestElementinaBSTJava test = new KthSmallestElementinaBSTJava();
        System.out.println(test.kthSmallest(
            TreeNode.fromList(new Integer[]{2, 1, 3}),
            2
        ));
    }
}