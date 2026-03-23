

import node_structure.TreeNode;

public class InvertaBinaryTreeJava {
    public TreeNode invertTree(TreeNode root) {
        if (null == root) return root;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }


    public static void main(String[] args) {
        InvertaBinaryTreeJava test = new InvertaBinaryTreeJava();
        System.out.println(test.invertTree(
            TreeNode.fromList(new Integer[]{1, null, 3, null, null, 6})
        ));
    }
}
