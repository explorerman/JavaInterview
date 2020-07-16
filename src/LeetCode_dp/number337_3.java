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
public class number337_3 {
    /**
     * 我们换一种办法来定义此问题
     * <p>
     * 每个节点可选择偷或者不偷两种状态，根据题目意思，相连节点不能一起偷
     * <p>
     * 当前节点选择偷时，那么两个孩子节点就不能选择偷了
     * 当前节点选择不偷时，两个孩子节点只需要拿最多的钱出来就行(两个孩子节点偷不偷没关系)
     * 我们使用一个大小为 2 的数组来表示 int[] res = new int[2] 0 代表不偷，1 代表偷
     * 任何一个节点能偷到的最大钱的状态可以定义为
     * <p>
     * 当前节点选择不偷：当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
     * 当前节点选择偷：当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
     * 表示为公式如下
     * root[0] = Math.max(rob(root.left)[0], rob(root.left)[1]) + Math.max(rob(root.right)[0], rob(root.right)[1])
     * root[1] = rob(root.left)[0] + rob(root.right)[0] + root.val;
     */
    public int rob(TreeNode root) {
        int[] result = rob2(root);
        return Math.max(result[0], result[1]);
    }

    public int[] rob2(TreeNode root) {
        if (root == null) return new int[2];
        int[] result = new int[2];

        int[] left = rob2(root.left);
        int[] right = rob2(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;
        return result;
    }

}
