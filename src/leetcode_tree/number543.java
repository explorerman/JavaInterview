package leetcode_tree;

/**
 * @author 李杰
 * @version 1.0
 * @Description 二叉树的直径
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/7/23 14:26
 * @title 标题: 二叉树的直径
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number543 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        //将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
        max = Math.max(max, left + right);
        //返回节点深度
        return Math.max(left, right) + 1;
    }
}
