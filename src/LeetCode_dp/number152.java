package LeetCode_dp;

/**
 * @author 李杰
 * @version 1.0
 * @Description 乘积最大子数组
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/6/16 14:03
 * @title 标题: 乘积最大子数组
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number152 {
    //暴力破解
    public static int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int len = nums.length;
        if(len == 1) return nums[0];
        //levelMax表示每层子数组的最大值，temp是递归求每层数组和的临时值
        //例如：[2,3,-2,4]，其实level表示：2开头层的最大值，temp表示：2 * 3,2*3*-2等的乘积
        int temp, levelMax;
        for (int i = 0; i < len; i++) {
            temp = nums[i];
            levelMax = nums[i];
            for (int j = i + 1; j < len; j++) {
                temp *= nums[j];
                //求出当前层的最大值
                levelMax = Math.max(levelMax, temp);
            }
            //判断当前层和当前结果的值，取最大
            res = Math.max(levelMax, res);
        }
        System.out.println(res);
        return res;
    }
    //动态规划版本
    public static int maxProduct2(int[] nums){
        int len = nums.length;
        if(len == 0) return nums[0];
        int max = Integer.MIN_VALUE, maxDp = nums[0], minDp = nums[0];
        for (int i = 1; i < len; i++) {
            if(nums[i] < 0){
                int temp = maxDp;
                maxDp = minDp;
                minDp = temp;
            }
            maxDp = Math.max(nums[i], maxDp * nums[i]);
            minDp = Math.min(nums[i], minDp * nums[i]);
            max = Math.max(maxDp, max);
        }
        System.out.println(max);
        return max;
    }



    public static void main(String[] args) {
        maxProduct2(new int[]{2,3,-2,4});
    }
}
