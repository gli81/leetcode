

import node_structure.TreeNode;

public class BalancedBinaryTreeJava {
    public boolean isBalanced1(TreeNode root) {
        if (null == root) return true;
        int l = depth(root.left);
        int r = depth(root.right);
        return l <= r + 1 && r <= l + 1 &&
            isBalanced1(root.left) && isBalanced1(root.right);
    }

    private int depth(TreeNode root) {
        if (null == root) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }


    public static void main(String[] args) {
        BalancedBinaryTreeJava test = new BalancedBinaryTreeJava();
        System.out.println(test.isBalanced1(
            TreeNode.fromList(new Integer[]{
                1, 2, 2, 3, null, null, 3, 4, null, null, null, null, null, null, 4
            })
        ));
    }
}