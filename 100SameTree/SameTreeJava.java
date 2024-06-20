

import node_structure.TreeNode;

public class SameTreeJava {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return inorder_traversal(p, q);
    }

    private boolean inorder_traversal(TreeNode p, TreeNode q) {
        if (null == p && null == q) return true;
        if (null == p || null == q) return false;
        // left
        if (!inorder_traversal(p.left, q.left)) return false;
        // self
        if (p.val != q.val) return false;
        // right
        if (!inorder_traversal(p.right, q.right)) return false;
        return true;
    }
}


// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;


//     TreeNode() {}
//     TreeNode(int val) {this.val = val;}
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }