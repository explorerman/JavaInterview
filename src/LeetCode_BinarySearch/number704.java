package LeetCode_BinarySearch;

/**
 * @author 李杰
 * @version 1.0
 * @Description 二分查找
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/8/6 11:08
 * @title 标题: 二分查找
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number704 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(target == nums[mid]){
                return mid;
            }else if(target > nums[mid]){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
