package leetcode_tree;

import java.util.ArrayList;
import java.util.List;

public class number257 {

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

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.right = n5;
        new number257().binaryTreePaths(n1);
    }

}
