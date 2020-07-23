package leetcode_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李杰
 * @version 1.0
 * @Description 二叉树中的最大路径和 [1,-2,-3,1,3,-2,null,-1]
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/7/23 11:33
 * @title 标题: 二叉树中的最大路径和
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number124 {
    //思路：使用前序遍历，将结果放入list中，然后使用dp来求，数组中的最大子序列的值
    private List<Integer> list = new ArrayList<>();

    public int maxPathSum(TreeNode root) {
        preOrder(root);
        Integer[] nums = list.toArray(new Integer[0]);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private List<Integer> preOrder(TreeNode root) {
        if (root == null) return list;
        preOrder(root.left);
        list.add(root.val);
        preOrder(root.right);
        return list;
    }

    public static void main(String[] args) {

    }
}

