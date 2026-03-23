

import node_structure.TreeNode;

public class DiameterofBinaryTreeJava {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = new int[]{0};
        int l = depth(root.left, ans);
        int r = depth(root.right, ans);
        return Math.max(ans[0], l + r + 1) - 1;
    }

    private int depth(TreeNode node, int[] ans) {
        if (null == node) return 0;
        int l = depth(node.left, ans);
        int r = depth(node.right, ans);
        ans[0] = Math.max(l + r + 1, ans[0]);
        return Math.max(l, r) + 1;
    }

}
