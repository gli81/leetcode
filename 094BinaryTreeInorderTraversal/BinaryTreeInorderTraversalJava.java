

import java.util.List;
import java.util.ArrayList;

public class BinaryTreeInorderTraversalJava {
    public List<Integer> inorderTraversal(TreeNode root) {
        return null;
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