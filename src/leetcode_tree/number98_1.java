package leetcode_tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class number98 {
    // 节点的左子树只包含小于当前节点的数。
    // 节点的右子树只包含大于当前节点的数。
    // 所有左子树和右子树自身必须也是二叉搜索树。
    //[3,1,5,0,2,4,6]
    public boolean isValidBST(TreeNode root){
        if(root == null) return true;
        if(isSorted(root)){
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
            if (previous.compareTo(current) >= 0) {
                return false;
            }
            previous = current;
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
