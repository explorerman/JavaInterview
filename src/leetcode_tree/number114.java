package leetcode_tree;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

public class number114 {
//     1
//   / \
//  2   5
// / \   \
//3   4   6
    //解法1：非递归，从根到子树
    public void flatten(TreeNode root) {
       TreeNode cur = root;
       while (cur != null){
           if(cur.left != null){
               TreeNode temp = cur.left;
               while (temp.right != null){
                   temp = temp.right;
               }
               temp.right = cur.right;
               cur.right = cur.left;
               cur.left = null;
           }
           cur = cur.right;
       }
    }
    //解法2:后序遍历，从子树到根。
    public void flatten2(TreeNode root) {
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null){
            root = root.right;
        }
        root.right = temp;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.left = n2;
        n1.right = n5;
        n2.left = n3;
        n2.right = n4;
        n5.right = n6;
        new number114().flatten(n1);
    }

}
