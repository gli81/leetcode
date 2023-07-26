

import java.util.List;
import java.util.ArrayList;

public class UniqueBinarySearchTreesIIJava {
    public List<TreeNode> generateTrees(int n) {
        return null;
    }

    public List<TreeNode> generateTrees4(int n) {
        List<TreeNode> pre = new ArrayList<>();
        if (n == 0) return pre;
        pre.add(null);
        // TODO insert a number n times
        for (int i = 1; i < n + 1; i++) {
            // create node
            List<TreeNode> cur = new ArrayList<>();
            // 尝试给之前的每个解添加一个数字
            for (TreeNode root : pre) {
                // insert the new one as parent of the root
                // (root is left child of new node)
                cur.add(new TreeNode(i, root, null));
                // newly inserted node can't be left child of any node in the tree
                /*
                 * 
                 *   2         2          2
                 *  / \  =>   / \   or   / \
                 * 1  3      1  4       1  3
                 *             /            \
                 *            3             4
                 */
                // let the new one be the right child of each of the right-most line
            }
        }


    }



    public static void main(String[] args) {
        UniqueBinarySearchTreesIIJava test = 
            new UniqueBinarySearchTreesIIJava();
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