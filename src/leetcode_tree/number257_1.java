package leetcode_tree;

import java.util.ArrayList;
import java.util.List;

public class number257_1 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root != null) reTree(root,"",res);
        return res;
    }
    public void reTree(TreeNode root,String sb, List<String> res){
        sb += root.val;
        if(root.left == null && root.right == null){
            res.add(sb);
        }else{
            sb += "->";
            if(root.left != null) reTree(root.left, sb, res);
            if(root.right != null) reTree(root.right, sb, res);
        }
    }
}
