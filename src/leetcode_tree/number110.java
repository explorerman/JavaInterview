package leetcode_tree;

public class number110 {
    public static boolean isBalanced(TreeNode root) {
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
    public static int depth(TreeNode root){
        if(root == null) return 0;
        int leftLength = depth(root.left) + 1;
        int rightLength = depth(root.right) + 1;
        return Math.max(leftLength,rightLength);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.right = n5;
        n4.left = n6;
        n5.right = n7;
        boolean a = isBalanced(n1);
        System.out.println(a);
    }
}
