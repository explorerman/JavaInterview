package leetcode_tree;

import java.util.ArrayList;
import java.util.List;
//二叉树的中序遍历
public class number94 {
    //中序遍历的顺序是：左，中，右
    //前序：中，左，右
    //后序：左，右，中
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }
    private void inOrder(TreeNode root, List<Integer> result) {
        if(root == null) return;
        if(root.left != null)  inOrder(root.left, result);
        result.add(root.val);
        if(root.right != null) inOrder(root.right, result);
    }
}
