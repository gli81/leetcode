

import java.util.List;
import java.util.ArrayList;
import node_structure.TreeNode;

public class UniqueBinarySearchTreesIIJava {
    public List<TreeNode> generateTrees(int n) {
        return null;
    }

    public List<TreeNode> generateTrees4(int n) {
        List<TreeNode> pre = new ArrayList<>();
        if (n == 0) return pre;
        pre.add(null);
        // TODO insert a number n times
        for (int i = 1; i <= n; i++) {
            // create list
            List<TreeNode> cur = new ArrayList<>();
            // add new node to each of nodes in pre
            for (TreeNode root : pre) {
                // insert the new one as parent of the root
                // (root is left child of new node)
                cur.add(new TreeNode(i, root, null));
                // newly inserted node can't be
                // left child of any node in the tree
                /*
                 * 
                 *   2         2          2
                 *  / \  =>   / \   or   / \
                 * 1  3      1  4       1  3
                 *             /            \
                 *            3             4
                 */
                // let the new one be the right child of
                // each of the right-most line
                for (int j = 0; j <= n; j++) {
                    // control insertion position with j
                    // copy right child
                    TreeNode root_copy = copy_node(root);
                    TreeNode right = root_copy;
                    // keep k's position to save time
                    int k = 0;
                    for (; k < j; k++) {
                        // 遇到右子树到头了
                        if (null == right) break;
                        right = right.right;
                    }
                    // if break from the for loop
                    // no more right child
                    if (null == right) break;
                    // right.right => new
                    // new.right => old right.right
                    right.right = new TreeNode(i,
                                               right.right,
                                               null);
                    cur.add(root_copy);
                }
            }
            pre = new ArrayList<>(cur);
        }
        return pre;
    }

    private TreeNode copy_node(TreeNode original) {
        if (original == null) return null;
        TreeNode copy = new TreeNode(original.val);
        copy.left = copy_node(original.left);
        copy.right = copy_node(original.right);
        return copy;
    }


    public static void main(String[] args) {
        UniqueBinarySearchTreesIIJava test = 
            new UniqueBinarySearchTreesIIJava();
        test.generateTrees4(3);
    }
}
