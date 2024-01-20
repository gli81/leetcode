

public class ConvertSortedArraytoBinarySearchTreeJava {
    public TreeNode sortedArrayToBST(int[] nums) {

    }


    public static void main(String[] args) {
        ConvertSortedArraytoBinarySearchTreeJava test = 
            new ConvertSortedArraytoBinarySearchTreeJava();
        System.out.println("No test");
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
