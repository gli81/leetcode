

import java.util.Stack;

public class RecoverBinarySearchTreeJava {
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        if (null == root) return;
        stk.push(root);
        TreeNode pre, first, second;
        pre = null;
        first = null;
        second = null;
        while (!stk.isEmpty()) {
            if (null != root.left) {
                stk.push(root.left);
                root = root.left;
            } else {
                root = stk.pop(); // main purpose: get the
                                  // leaf out of the stack
                if (null != pre && pre.val >= root.val) {
                    // find something wrong with this tree
                    // check if this is the first time
                    if (null != first) {
                        second = root;
                    } else {
                        // first time find error
                        first = pre;
                        second = root; // ? can I ignore this?
                    }
                }
                pre = root;
                while (null == root.right &&
                       !stk.isEmpty()) {
                    // nothing on the right keep moving up
                    root = stk.pop();
                    if (pre.val >= root.val) {
                        if (null != first) {
                            second = root;
                        } else {
                            // first time find error
                            first = pre;
                            second = root; // ? can I ignore this?
                        }
                    }
                    pre = root;
                }
                if (null != root.right) {
                    stk.push(root.right);
                    root = root.right;
                }
            }
        }
        // fix the tree
        int temp = second.val;
        second.val = first.val;
        first.val = temp;
    }


    public static void main(String[] args) {
        System.out.println("SB");
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
