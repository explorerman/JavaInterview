package leetcode_tree;

public class number114_1 {
    //
//     1
//   / \
//  2   5
// / \   \
//3   4   6
//
// 将其展开为：
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6
//
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode leftestNode = null;
        TreeNode middleRoot = null;
        TreeNode rightestNode = null;
        if(root.left == null && root.right == null){
            leftestNode = root;
            return;
        }

        flatten(root.left);
        middleRoot = root;
        if(middleRoot.right  != null){
            leftestNode.right = middleRoot.right;
            middleRoot.right = leftestNode;
        }
        flatten(root.right);
    }
}
