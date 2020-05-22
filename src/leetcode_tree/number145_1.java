package leetcode_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class number145_1 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.peek();
            if(temp.right != null) stack.push(temp.right);
            if(temp.left != null) stack.push(temp.left);
            res.add(temp.val);
        }
        return res;
    }
}
