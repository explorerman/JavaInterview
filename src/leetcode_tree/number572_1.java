package leetcode_tree;

import java.util.ArrayList;
import java.util.List;

public class number572 {
    private List<Integer> sList = new ArrayList<>();
    private List<Integer> tList = new ArrayList<>();
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null || t == null) return false;
        sTraversal(s);
        tTraversal(t);
        sList.retainAll(tList);
        if(sList.size() > 0){
            return true;
        }
        return false;
    }
    public List<Integer> sTraversal(TreeNode root) {
        if(root == null) return sList;
        sTraversal(root.left);
        sList.add(root.val);
        sTraversal(root.right);
        return sList;
    }
    public List<Integer> tTraversal(TreeNode root) {
        if(root == null) return tList;
        tTraversal(root.left);
        tList.add(root.val);
        tTraversal(root.right);
        return tList;
    }

    public static void main(String[] args) {
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        n3.left = n4;
        n3.right = n5;
        n4.left = n1;
        n4.right = n2;
        tn4.left = tn1;
        tn4.right = tn2;
        new number572().isSubtree(n3,tn4);

    }
}
