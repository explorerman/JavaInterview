package LeetCode_byte_dance;

/**
 * @author 李杰
 * @version 1.0
 * @Description 搜索旋转排序数组
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/5/9 11:08
 * @title 标题: 搜索旋转排序数组（暴力破解，复杂度为n）
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number33 {
    public int search(int[] nums, int target) {
        if(nums.length < 0) return -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }
}
