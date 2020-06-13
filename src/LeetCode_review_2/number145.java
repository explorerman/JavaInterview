package LeetCode_review_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class number145 {
    public List<Integer> postOrder(TreeNodeReview root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNodeReview> stack = new Stack<>();
        if(root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNodeReview cur = stack.pop();
            res.add(cur.value);
            if(cur.left != null) stack.push(cur.left);
            if(cur.right != null) stack.push(cur.right);
        }
        return res;
    }
}
