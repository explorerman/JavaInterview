package LeetCode_review_2;

//二叉树的最小深度
public class number111 {
    public int minDepth(TreeNode root){
        if(root == null) return 0;
        int leftDepth = minDepth(root.left) + 1;
        int rightDepth = minDepth(root.right) + 1;
        if(root.left == null){
            return rightDepth;
        }else if (root.right == null){
            return leftDepth;
        }
        return Math.min(leftDepth, rightDepth);
    }
}
