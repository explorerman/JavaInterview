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
public class number189 {
//    [1,2,3,4,5,6,7] 和 k = 3
    //暴力破解，每次旋转1个位置，时间复杂度是O(k*n),空间复杂度是O(1)
    public void rotate(int[] nums, int k) {
        //previous一直指定数组的末尾，每次都与数组的末尾进行交换
        int temp, previous;
        //因为k只限制了非负数，所以可能会有周期性的变化，所以取余来判断真正需要交换的元素
        int time = k % nums.length;
        if(time == 0) return;
        for (int i = 0; i < time; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
}
