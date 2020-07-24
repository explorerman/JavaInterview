package LeetCode_BinarySearch;

/**
 * @author 李杰
 * @version 1.0
 * @Description 寻找峰值
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/7/24 11:15
 * @title 标题: 寻找峰值
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number162_2 {
    //二分查找.让左右指针来循环条件
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (; left < right; ) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid + 1]){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

}
