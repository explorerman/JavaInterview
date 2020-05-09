package LeetCode_byte_dance;

/**
 * @author 李杰
 * @version 1.0
 * @Description 盛最多水的容器
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/5/8 12:40
 * @title 标题: 盛最大水的容器
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number11_1 {
    public int maxArea(int[] height){
        int len = height.length;
        if(len < 2) return -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                max = Math.max(max, (j - i) * Math.min(height[i],height[j]));
            }
        }
        return max;
    }
}
