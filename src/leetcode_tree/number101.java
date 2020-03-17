package leetcode_tree;

public class number101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return  isSameTree(root.left, root.right);
    }
    public boolean isSameTree(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val == right.val){
            return isSameTree(left.left,right.right) && isSameTree(left.right,right.left);
        }else{
            return false;
        }
    }
    public static void main(String[] args) {

    }
}
