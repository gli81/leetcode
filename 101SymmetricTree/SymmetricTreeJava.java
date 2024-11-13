

import node_structure.TreeNode;

public class SymmetricTreeJava {
    public boolean isSymmetric(TreeNode root) {
        return isSymHelper(root.left, root.right);
    }

    private boolean isSymHelper(TreeNode left, TreeNode right) {
        if (null == left && null == right) return true;
        if (null == left || null == right) return false;
        if (left.val != right.val) return false;
        return isSymHelper(
            left.left, right.right
        ) && isSymHelper(
            left.right, right.left
        );
    }
}
