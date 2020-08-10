package LeetCode_array;

/**
 * @author 李杰
 * @version 1.0
 * @Description 下一个更大元素2
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/8/10 14:52
 * @title 标题: 下一个更大元素2
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number503 {
    //输入: [1,2,1]  1,2,1,1,2,1
    //输出: [2,-1,2]
    //为了解决循环数组的问题，想到的方法是将数组复制到长度是2倍的数组中，然后找元素，但在最后的几个大数组中，超时了
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int[] numsToNums = new int[len + len];
        for (int i = 0; i < len; i++) {
            numsToNums[i] = nums[i];
            numsToNums[i + len] = nums[i];
        }
        for (int i = 0; i < len; i++) {
            res[i] = findFirstLargeNum(nums[i], numsToNums, i);
        }
        return res;
    }

    private int findFirstLargeNum(int target, int[] nums,int index) {
        int len = nums.length;
        for (int i = index; i < len; i++) {
            if(target == nums[index]){
                for (int j = i +1; j < len; j++) {
                    if(nums[j] > target){
                        return nums[j];
                    }
                }
            }
        }
        return -1;
    }
}
