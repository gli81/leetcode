

import node_structure.TreeNode;

public class SameTreeJava {
    // public boolean isSameTree(TreeNode p, TreeNode q) {
    //     return inorder_traversal(p, q);
    // }

    // private boolean inorder_traversal(TreeNode p, TreeNode q) {
    //     if (null == p && null == q) return true;
    //     if (null == p || null == q) return false;
    //     // left
    //     if (!inorder_traversal(p.left, q.left)) return false;
    //     // self
    //     if (p.val != q.val) return false;
    //     // right
    //     if (!inorder_traversal(p.right, q.right)) return false;
    //     return true;
    // }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null == q) return true;
        if (null == p || null == q) return false;
        // left
        if (!isSameTree(p.left, q.left)) return false;
        // node
        if (p.val != q.val) return false;
        // right
        if (!isSameTree(p.right, q.right)) return false;
        return true;
    }


    public static void main(String[] args) {
        SameTreeJava test = new SameTreeJava();
        System.out.println(
            test.isSameTree(
                TreeNode.fromList(new Integer[]{1, 2, 3}),
                TreeNode.fromList(new Integer[]{1, 2, 3})
            )
        );
        System.out.println(
            test.isSameTree(
                TreeNode.fromList(new Integer[]{1, 2, 3}),
                TreeNode.fromList(new Integer[]{1, 2, null})
            )
        );
        System.out.println(
            test.isSameTree(
                TreeNode.fromList(new Integer[]{1, 2, 1}),
                TreeNode.fromList(new Integer[]{1, 1, 2})
            )
        );
    }
}
