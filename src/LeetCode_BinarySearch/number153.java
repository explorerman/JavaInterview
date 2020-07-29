package LeetCode_BinarySearch;

import java.util.Arrays;

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
public class number153 {
    //不符合题意，因为使用了排序方法
    public int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }
}
