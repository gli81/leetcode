

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class ValidateBinarySearchTreeJava {
    public boolean isValidBST0(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        inorder_traversal(root, lst);
        for (int i = 1; i < lst.size(); i++) {
            if (lst.get(i - 1) >= lst.get(i)) return false;
        }
        return true;
    }
    
    private void inorder_traversal(TreeNode root,
                                   List<Integer> lst) {
        if (root == null) return;
        inorder_traversal(root.left, lst);
        lst.add(root.val);
        inorder_traversal(root.right, lst);
        return;
    }

    public void inorder_traversal_stack(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        if (null == root) return;
        stk.push(root);
        while (stk.size() != 0) {
            if (null != root.left) {
                stk.push(root.left);
                root = root.left;
            } else {
                // get here when every node on the
                // left-most line is in the stack
                // root at the leaf of left-most line
                root = stk.pop();
                System.out.println(root.val);
                // if not root has right child,
                // don't stop poping things out
                // keep moving up
                while (null == root.right && stk.size() > 0) {
                    root = stk.pop();
                    System.out.println(root.val);
                }
                // if find one node that has right child
                // add that child to the stk
                // take that child through the
                // push left-most line... process
                if (null != root.right) {
                    stk.push(root.right);
                    root = root.right;
                }
            }
        }
    }


    public static void main(String[] args) {
        ValidateBinarySearchTreeJava test =
            new ValidateBinarySearchTreeJava();
        TreeNode test1 = new TreeNode(7,
                        new TreeNode(4,
                    new TreeNode(3,
                new TreeNode(1, null,
                                    new TreeNode(2)), null),
                                            new TreeNode(6,
                                        new TreeNode(5), null)),
                                                null);
        test.inorder_traversal_stack(test1);
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
