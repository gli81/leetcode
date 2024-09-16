

import java.util.Map;
import java.util.HashMap;
import node_structure.TreeNode;

public class ConstructBinaryTreefromPreorderandInorderTraversalJava {
    public TreeNode buildTree(
        int[] preorder,
        int[] inorder
    ) {
        // 用一个Map来记录每个element的index
        // 以快速获取某一element在inorder traversal中的index
        Map<Integer, Integer> idx_map =
            new HashMap<Integer, Integer>();
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            idx_map.put(inorder[i], i);
        }
        // 对于preorder traversal的结果
        // [root, [preorder of left child], [preorder of right child]]
        // 对于inorder traversal的结果
        // [[inorder of left child], root, [inorder of right child]]
        // 先找root
        // 再根据[preorder of left child]和[inorder of left child]
        // 找到左子树的root
        // 再根据[preorder or right child]和[inorder of right child]
        // 找到右子树的root
        return build_tree_helper(
            preorder, inorder,
            0, n - 1, 0, n - 1,
            idx_map
        );
    }

    private TreeNode build_tree_helper(
        int[] preorder, int[] inorder,
        int preorder_l, int preorder_r,
        int inorder_l, int inorder_r,
        Map<Integer, Integer> idx_map
    ) {
        // 结束条件
        if (preorder_r < preorder_l) return null;
        // 创建root
        TreeNode root = new TreeNode(preorder[preorder_l]);
        // 找到root在inorder里的位置
        int root_in_inorder = idx_map.get(
            preorder[preorder_l]
        );
        // 还要找到左子树的长度
        // 来决定preorder里左子树的结束位置
        // root_in_inorder - inorder_l ==> left subtree length
        int left_end = preorder_l + (root_in_inorder - inorder_l);
        root.left = build_tree_helper(
            inorder, preorder,
            inorder_l, root_in_inorder - 1,
            preorder_l + 1, left_end, idx_map
        );
        root.right = build_tree_helper(
            inorder, preorder,
            root_in_inorder + 1, inorder_r,
            left_end + 1, preorder_r, idx_map
        );
        return root;
    }


    public static void main(String[] args) {
        ConstructBinaryTreefromPreorderandInorderTraversalJava test = 
            new ConstructBinaryTreefromPreorderandInorderTraversalJava();
        System.out.println(test.buildTree(
            new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }
}
