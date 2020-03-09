package leetcode_tree;

public class number572 {
    public boolean isSubtree(TreeNode s, TreeNode t){
        if(s == null) return false;
        if(isSameTree(s,t)){
            return true;
        }
        return isSubtree(s.left,t) || isSubtree(s.right,t);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val == q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }else{
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
