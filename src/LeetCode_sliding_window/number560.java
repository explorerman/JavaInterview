package LeetCode_sliding_window;

/**
 * @author 李杰
 * @version 1.0
 * @Description 和为K的子数组
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/8/6 10:08
 * @title 标题: 和为K的子数组
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number560 {
    //输入:nums = [1,1,1], k = 2  [1] 0  [-1,-1,1] 0
    //输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end >= 0; end--) {
                sum += nums[end];
                if(sum == k) count++;
            }
        }
        return count;
    }

}
