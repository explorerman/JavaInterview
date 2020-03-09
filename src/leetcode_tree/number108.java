package leetcode_tree;

public class number108 {
//    public TreeNode sortedArrayToBST(int[] nums) {
//        if(nums.length == 0) return null;
//        TreeNode res;
//        for (int i = 0; i < nums.length; i++){
//            new TreeNode(nums[0]);
//            new TreeNode(nums[1]);
//            new TreeNode(nums[2]);
//        }
//
//        if(isBalanced(res) && isSearched(res)){
//            return res;
//        }
//        return res;
//    }
//    public static TreeNode establish(){
//
//    }
//    public static boolean isBalanced(TreeNode root) {
//        if(root == null) return true;
//        int left = depth(root.left);
//        int right = depth(root.right);
//        if(Math.abs(left - right) > 1) {
//            return false;
//        }
//        if(isBalanced(root.left) && isBalanced(root.right)){
//            return true;
//        }
//        return false;
//    }
//    public static int depth(TreeNode root){
//        if(root == null) return 0;
//        int leftLength = depth(root.left) + 1;
//        int rightLength = depth(root.right) + 1;
//        return Math.max(leftLength,rightLength);
//    }
//
//    public static boolean isSearched(TreeNode root){
//        if(root == null) return true;
//        if(root.val < root.left.val || root.val > root.right.val){
//            return false;
//        }
//        if(isSearched(root.left) && isSearched(root.right)){
//            return true;
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//
//    }
}
