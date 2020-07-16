package LeetCode_dp;

/**
 * @author 李杰
 * @version 1.0
 * @Description 打家劫舍3
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/7/16 9:36
 * @title 标题: 打家劫舍3
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number337_1 {
    /**
     结果来源于两个：
     1.爷爷节点+孙子节点的值
     2.儿子节点的值
     上面二者进行比较，哪个大，返回谁
     */
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int meney = root.val;
        if(root.left != null) {
            meney += (rob(root.left.left) + rob(root.left.right));
        }
        if(root.right != null){
            meney += (rob(root.right.left) + rob(root.right.right));
        }
        return Math.max(meney, rob(root.left) + rob(root.right));
    }
}
