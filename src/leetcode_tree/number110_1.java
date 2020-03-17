package leetcode_tree;


public class number110 {
    public  boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = depth(root.left);
        int right = depth(root.right);
        if(Math.abs(left - right) > 1) {
            return false;
        }
        if(isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }
        return false;
    }
    public  int depth(TreeNode root){
        if(root == null) return 0;
        int leftLength = depth(root.left) + 1;
        int rightLength = depth(root.right) + 1;
        return Math.max(leftLength,rightLength);
    }

    public static void main(String[] args) {

    }
}
