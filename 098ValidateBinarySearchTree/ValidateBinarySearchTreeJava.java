

import java.util.List;
import java.util.ArrayList;

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

    private void inorder_traversal_stack(TreeNode root) {
        
    }


    public static void main(String[] args) {
        
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
