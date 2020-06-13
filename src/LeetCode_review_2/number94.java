package LeetCode_review_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class number94 {

    public List<Integer> inorder(TreeNodeReview root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNodeReview> stack = new Stack<>();
        TreeNodeReview cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(root);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.value);
            cur = cur.right;
        }
        return res;
    }

}
class TreeNodeReview {
    int value;
    TreeNodeReview left;
    TreeNodeReview right;

    TreeNodeReview(int value){
        this.value = value;
    }
}
