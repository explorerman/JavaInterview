package LeetCode_array;

/**
 * @author 李杰
 * @version 1.0
 * @Description 旋转数组
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/7/31 9:23
 * @title 标题: 旋转数组
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number189_1 {
    //    [1,2,3,4,5,6,7] 和 k = 3
    //使用多次反转来达到旋转,时间复杂度为O(n),空间复杂度为O(1)，所以元素被反转了3次
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) return;
        //1.将数组整体反转一次
        reverse(nums, 0, nums.length - 1);
        //2.将数组的前K个元素反转
        reverse(nums, 0, k - 1);
        //3.将数组的后N-K个元素反转
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
