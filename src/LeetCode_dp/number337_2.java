package LeetCode_dp;

import java.util.HashMap;

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
public class number337_2 {
    /**
     结果来源于两个：
     1.爷爷节点+孙子节点的值
     2.儿子节点的值
     上面二者进行比较，哪个大，返回谁
     */
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> memo = new HashMap<>();
        return rob(root, memo);
    }
    int rob(TreeNode root, HashMap<TreeNode, Integer> memo){
        if(root == null) return 0;
        if(memo.containsKey(root)) return memo.get(root);
        int money = root.val;
        if(root.left != null){
            money += (rob(root.left.left, memo) + rob(root.left.right, memo));
        }
        if(root.right != null){
            money += (rob(root.right.left, memo) + rob(root.right.right, memo));
        }
        int result = Math.max(money, rob(root.left, memo) + rob(root.right, memo));
        memo.put(root, result);
        return result;
    }
}
