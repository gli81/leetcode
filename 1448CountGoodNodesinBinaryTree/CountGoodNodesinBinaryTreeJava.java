

import node_structure.TreeNode;

public class CountGoodNodesinBinaryTreeJava {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode root, int max) {
        if (null == root) return 0;
        int cur = root.val >= max ? 1 : 0;
        return dfs(root.left, Math.max(root.val, max)) +
            dfs(root.right, Math.max(root.val, max)) + cur;
            // root.val >= max ? 1 : 0;
    }


    public static void main(String[] args) {
        CountGoodNodesinBinaryTreeJava test =
            new CountGoodNodesinBinaryTreeJava();
        System.out.println(test.goodNodes(
            TreeNode.fromList(new Integer[]{2, 1, 1, 3, null, 1, 5})
        ));
        System.out.println(test.goodNodes(
            TreeNode.fromList(new Integer[]{1, 2, -1, 3, 4})
        ));
    }
}
