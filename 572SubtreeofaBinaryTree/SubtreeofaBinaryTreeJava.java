

import node_structure.TreeNode;

public class SubtreeofaBinaryTreeJava {
    public boolean isSubtree2(TreeNode root, TreeNode subRoot) {
        if (null == subRoot) return true;
        if (null == root) return false;
        if (isSameTree(root, subRoot)) return true;
        return isSubtree2(root.left, subRoot) || isSubtree2(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null == q) return true;
        if (null == p || null == q) return false;
        // left
        if (!isSameTree(p.left, q.left)) return false;
        if (p.val != q.val) return false;
        // right
        if (!isSameTree(p.right, q.right)) return false;
        return true;
    }


    public static void main(String[] args) {
        SubtreeofaBinaryTreeJava test = new SubtreeofaBinaryTreeJava();
        System.out.println(test.isSubtree2(
            TreeNode.fromList(new Integer[]{3, 4, 5, 1, 2}),
            TreeNode.fromList(new Integer[]{4, 1, 2})
        ));
    }
}