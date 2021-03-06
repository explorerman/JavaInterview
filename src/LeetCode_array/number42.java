package LeetCode_array;

/**
 * @author 李杰
 * @version 1.0
 * @Description 接雨水
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/6/28 15:20
 * @title 标题: 接雨水
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number42 {
    //暴力破解
    //直接按问题描述进行。对于数组中的每个元素，我们找出下雨后水能达到的最高位置，等于两边最大高度的较小值减去当前高度的值。
    public int trap(int[] height) {
        //初始化
        int ans = 0;
        int length = height.length;
        //从左向右扫描数组
        for (int i = 1; i < length; i++) {
            //初始化当前位置下，左边和右边最大高度
            int max_left = 0, max_right = 0;
            //找到左边最大的高度
            for (int j = i; j >= 0 ; j--) {
                max_left = Math.max(max_left, height[j]);
            }
            //找到右边最大的高度
            for (int j = i; j < length; j++) {
                max_right = Math.max(max_right, height[j]);
            }
            //因为题目说了柱子宽度是1，所以当前位置可以容纳的雨水，等于左右最低高度-当前的高度，进行累加就行
            ans += Math.min(max_left, max_right) - height[i];
        }
        return ans;
    }
}
