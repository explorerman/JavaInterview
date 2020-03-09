package leetcode_tree;

public class number112 {
    //利用回溯法，也就是dfs
    //
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
//
//
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        sum = sum - root.val;
        if(sum == 0 && root.left == null && root.right == null) return true;
        return (hasPathSum(root.left, sum) || hasPathSum(root.right, sum));
    }

    public static void main(String[] args) {

    }
}
