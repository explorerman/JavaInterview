package leetcode_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//二叉树的中序遍历  非递归
public class number94_1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return null;
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }
}
