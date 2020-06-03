package LeetCode_byte_dance;

import java.util.Arrays;

/**
 * @author 李杰
 * @version 1.0
 * @Description 下一个排列
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/6/3 12:12
 * @title 标题: 下一个排列
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */

public class number31 {
    public void nextPermutation(int[] nums) {
        int i, j, n = nums.length;
        for (i = n - 2; i >= 0; i--) {
            //从末尾往前面找，首次出现降序的数字
            if (nums[i] < nums[i + 1]) {
                //从末尾重新开始找，比首次出现降序的数字大的数字，然后break
                for (j = n - 1; j > i; j--) {
                    if (nums[j] > nums[i]) break;
                }
                //交换两个数字
                swap(nums, i, j);
                //从交换后的数字下一位开始到结束，重新排序
                reverse(nums, i + 1, n);
                return;
            }
        }
        //如果数组是倒序，则直接反转
        reverse(nums, 0, n);
    }

    private void reverse(int[] nums, int start, int end) {
        Arrays.sort(nums, start, end);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
//        new number31().reverse(new int[]{1,3,7,4,2,1}, 2, 5);
        int[] nums = new int[]{9,3,8,4,2,7};
        Arrays.sort(nums, 0, 6);
        System.out.println(nums);
    }

}
