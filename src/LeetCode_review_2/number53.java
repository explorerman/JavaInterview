package LeetCode_review_2;

/**
 * @author 李杰
 * @version 1.0
 * @Description 最大子序和
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/7/1 14:58
 * @title 标题: 最大子序和
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number53 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        //代表当前当前位置之前的最大值
        int cur = 0;
        for (int i = 0; i < len; i++){
            //i之前的最大值+i
            cur += nums[i];
            //当前位置和 上一位置的最值+当前位置的值 取最大值
            cur = Math.max(nums[i], cur);
            //更新全局最大值
            max = Math.max(max, cur);
        }
        return max;
    }
}
