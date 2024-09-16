

import node_structure.TreeNode;

public class BinaryTreeMaxPathSumJava {
    public int maxPathSum(TreeNode root) {
        int[] ans = new int[]{root.val};
        helper(root, ans);
        return ans[0];
    }

    private int helper(TreeNode root, int[] ans) {
        if (null == root) return 0;
        int left_max = Math.max(helper(root.left, ans), 0);
        int right_max = Math.max(helper(root.right, ans), 0);
        ans[0] = Math.max(ans[0], left_max + right_max + root.val);
        return root.val + Math.max(left_max, right_max);
    }


    public static void main(String[] args) {
        BinaryTreeMaxPathSumJava test = new BinaryTreeMaxPathSumJava();
        System.out.println(test.maxPathSum(
            TreeNode.fromList(new Integer[]{1, 2, 3})
        ));
        System.out.println(test.maxPathSum(
            TreeNode.fromList(new Integer[]{
                -15,
                10, 20,
                null, null, 15, 5,
                null, null, null, null, -5
            })
        ));
    }
}
