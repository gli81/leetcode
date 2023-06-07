

import java.util.List;
import java.util.ArrayList;

public class UniqueBinarySearchTreesIIJava {
    public List<TreeNode> generateTrees(int n) {
        return null;
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