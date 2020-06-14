package LeetCode_review_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class number145 {
    //利用前序遍历来做后序,前序是1，2，3.如果遍历方向成为：1，3，2 因为后序是：2，3，1,刚好是修改后前序遍历的逆序
    public List<Integer> postOrder(TreeNodeReview root) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNodeReview> stack = new Stack<>();
        if(root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNodeReview cur = stack.pop();
            res.addFirst(cur.value);
            if(cur.left != null) stack.push(cur.left);
            if(cur.right != null) stack.push(cur.right);
        }
        return res;
    }
}
