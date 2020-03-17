package leetcode_tree;

public class number226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        if(root.left != null){
            invertTree(root.left);
        }
        if(root.right != null){
            invertTree(root.right);
        }
        return root;
    }
}
