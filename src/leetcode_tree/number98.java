package leetcode_tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class number98 {
    //2,1,3

    public  boolean isValidBST(TreeNode root) {
        if(root == null) return true;
//        if(isValidBST2(root) && isSorted(root)){
//            return true;
//        }
        if(isSorted(root)){
            System.out.println(list);
            return true;
        }
        return false;
    }
    private List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return list;
        preorderTraversal(root.left);
        list.add(root.val);
        preorderTraversal(root.right);
        return list;
    }
    public boolean isSorted(TreeNode root) {
        if(root == null) return true;
        preorderTraversal(root);
        Iterator<Integer> iter = list.iterator();
        Integer current, previous = null;
        if(iter.hasNext()){
            previous = iter.next();
        }
        while (iter.hasNext()) {
            current = iter.next();
            if (previous.compareTo(current) > 0) {
                return false;
            }
            previous = current;
        }
        return true;
    }
     public boolean isValidBST2(TreeNode root) {
         if(root == null) return true;
         if(root.left != null && root.val <= root.left.val){
             return false;
         }
         if(root.right != null && root.val >= root.right.val){
             return false;
         }
         if(isValidBST(root.left) && isValidBST(root.right)){
             return true;
         }
         return false;
     }

    public static void main(String[] args) {
       TreeNode n1 = new TreeNode(2);
       TreeNode n2 = new TreeNode(1);
       TreeNode n3 = new TreeNode(3);
       n1.left = n2;
       n1.right = n3;
       System.out.println(new number98().isValidBST(n1));
    }
}
