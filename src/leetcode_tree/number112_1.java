package leetcode_tree;

public class number112_1 {
    //dfs,bfs,回溯法
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.val == sum && root.left == null && root.right == null) return true;
        int target = sum - root.val;
        if(root.left != null){
            target = target - root.left.val;
        }
        if(root.right != null){
            target = target - root.right.val;
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
