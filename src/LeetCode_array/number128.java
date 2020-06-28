package LeetCode_array;

import java.util.Arrays;

/**
 * @author 李杰
 * @version 1.0
 * @Description 最长连续序列
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/6/28 15:10
 * @title 标题: 最长连续序列
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number128 {
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        if(len == 1) return 1;
        int max = Integer.MIN_VALUE;
        Arrays.sort(nums);
        //初始化为1是因为，每个元素都是自己的递增子串
        int res = 1;
        //冒泡排序比较
        for(int i = 1; i < len; i++){
            if(nums[i] - nums[i - 1] == 1){
                res++;
            }else if(nums[i] == nums[i - 1]){
               continue;
            }else{
                max = Math.max(max, res);
                res = 1;
            }
        }
        //判断都是递增数组的可能
        max = Math.max(max, res);
        return max;
    }
}
