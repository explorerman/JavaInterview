package LeetCode_BinarySearch;

/**
 * @author 李杰
 * @version 1.0
 * @Description 寻找旋转排序数组中的最小值
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/7/29 16:28
 * @title 标题: 寻找旋转排序数组中的最小值
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number153_1 {
    //这道题不太适合用二分，直接找元素降序的index即可
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.min(nums[0],nums[1]);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i -1]){
                return nums[i];
            }
        }
        return nums[0];
    }
}
