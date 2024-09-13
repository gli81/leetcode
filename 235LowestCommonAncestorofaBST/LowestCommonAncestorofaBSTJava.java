

import node_structure.TreeNode;

public class LowestCommonAncestorofaBSTJava {
    public TreeNode lowestCommonAncestor(
        TreeNode root, TreeNode p, TreeNode q
    ) {
        int pval = p.val;
        int qval = q.val;
        // look for split
        while (true) {
            if (null != root && pval > root.val && qval > root.val) {
                root = root.right;
            } else if (null != root && pval < root.val && qval < root.val) {
                root = root.left;
            } else {//if (null != root && (pval == root.val || qval == root.val)) {
                return root;
            } //else {
            //     return root;
            // }
        }
    }


    public static void main(String[] args) {
        LowestCommonAncestorofaBSTJava test =
            new LowestCommonAncestorofaBSTJava();
        System.out.println(
            test.lowestCommonAncestor(
                TreeNode.fromList(new Integer[]{
                    5, 3, 8, 1, 4, 7, 9, null, 2
                }),
                new TreeNode(3), new TreeNode(8))
        );
        System.out.println(
            test.lowestCommonAncestor(
                TreeNode.fromList(new Integer[]{
                    5, 3, 8, 1, 4, 7, 9, null, 2
                }),
                new TreeNode(3), new TreeNode(4))
        );
    }
}
