package BIO;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class inOrder {
    public List<Integer> inoderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){

            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode temp = stack.pop();
            res.add(temp.val);
            cur = cur.right;
        }
        return res;
    }
}
