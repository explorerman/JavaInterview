package leetcode_tree;

/**
 * @author 李杰
 * @version 1.0
 * @Description 二叉树的直径，其实就是节点的左右子树的路径长
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/7/23 14:26
 * @title 标题: 二叉树的直径
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number543_1 {
    //定义一个变量，用于保存中间出现的最大值
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        //求每个节点的左右子树的路径和
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
