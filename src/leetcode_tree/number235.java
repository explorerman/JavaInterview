package leetcode_tree;

//二叉搜索树的最近公共祖先
public class number235 {
    //思路：如果p,q在不同的子树，则直接返回根节点，如果p,q在相同的子树，则返回p,q中深的节点
    //dfs 二叉搜索树
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val > Math.max(p.val,q.val)){
           return lowestCommonAncestor(root.left,p,q);
        }
        else if(root.val < Math.min(p.val, q.val)){
            return lowestCommonAncestor(root.right,p,q);
        }else {
            return root;
        }
    }
}
