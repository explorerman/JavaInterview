package leetcode_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//前序遍历二叉树  非递归
public class number144_1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.peek();
            stack.pop();
            res.add(temp.val);
            if(temp.right != null) stack.push(temp.right);
            if(temp.left != null) stack.push(temp.left);
        }
        return res;
    }
}
