package LeetCode_review_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class number144 {
    public List<Integer> preOrder(TreeNodeReview root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNodeReview> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            final TreeNodeReview cur = stack.pop();
            res.add(cur.value);
            if(cur.right != null) stack.push(cur.right);
            if(cur.left != null) stack.push(cur.left);
        }
        return res;
    }
}
