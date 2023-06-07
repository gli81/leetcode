

import java.util.List;
import java.util.ArrayList;

public class BinaryTreeInorderTraversalJava {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        get_ans(root, ans);
        return ans;
    }

    private void get_ans(TreeNode node, List<Integer> ans) {
        if (node == null) return;
        get_ans(node.left, ans);
        ans.add(node.val);
        get_ans(node.right, ans);
    }


    public static void main(String[] args) {
        BinaryTreeInorderTraversalJava test = 
            new BinaryTreeInorderTraversalJava();
        System.out.println(
            test.inorderTraversal(new TreeNode(1,
                                               null,
                                               new TreeNode(2,
                                                            new TreeNode(3), null))));
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;


    TreeNode() {}
    TreeNode(int val) {this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}