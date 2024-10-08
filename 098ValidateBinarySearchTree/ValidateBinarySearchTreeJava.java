

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import node_structure.TreeNode;

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

    public boolean isValidBST4(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        if (null == root) return true;
        stk.push(root);
        TreeNode pre = null;
        while (stk.size() > 0) {
            if (null != root.left) {
                stk.push(root.left);
                root = root.left;
            } else {
                root = stk.pop();
                if (pre != null && pre.val >= root.val) return false;
                pre = root;
                while (null == root.right && stk.size() != 0) {
                    root = stk.pop();
                    if (pre.val >= root.val) return false;
                    pre = root;
                }
                if (null != root.right) {
                    stk.push(root.right);
                    root = root.right;
                }
            }
        }
        return true;
    }

    private void inorder_traversal_stack(TreeNode root) {
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

    public boolean isValidBST4b(TreeNode root) {
        if (null == root) return true;
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        TreeNode prev = null;
        while (stk.size() != 0) {
            while (null != root.left) {
                stk.push(root.left);
                root = root.left;
            }
            // compare when out of stack
            root = stk.pop();
            if (null != prev && prev.val >= root.val) return false;
            prev = root;
            while (null == root.right && stk.size() > 0) {
                root = stk.pop();
                // compare when pop
                if (null != prev && prev.val >= root.val) return false;
                prev = root;
            }
            if (null != root.right) {
                stk.push(root.right);
                root = root.right;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        ValidateBinarySearchTreeJava test =
            new ValidateBinarySearchTreeJava();
        TreeNode test1 = TreeNode.fromList(
            new Integer[]{
                7,
                4, null,
                3, 6, null, null,
                1, null, 5, null, null, null, null, null,
                null, 2,
            }
        );
        TreeNode test8 = TreeNode.fromList(
            new Integer[] {
                3, 1, 5, 0, 2, 4, 6, null, null, null, 3
            }
        );
        System.out.println(test.isValidBST4b(test8));
    }
}

