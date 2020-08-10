package LeetCode_array;

import java.util.Arrays;
import java.util.Stack;

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
public class number503_2 {
    //输入: [1,2,1]  1,2,1,1,2,1
    //输出: [2,-1,2]
    //使用单调栈,从头开始遍历
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        //存放结果
        int[] res = new int[len];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len * 2; i++) {
            // 对于当前元素,弹出栈中小于当前元素的元素,这些被弹出的元素的"下一个更大元素"就是当前元素
            // 一个元素只有入栈后再被弹出,才能得到该元素的"下一个更大元素",否则无"下一个更大元素",res[i]默认为-1
            // 例如,对于最大的元素,其一直留在栈中无法被弹出,因此其"下一个更大元素"默认为-1
            while (!stack.empty() && nums[i % len] > nums[stack.peek()]){
                int index = stack.pop();
                res[index] = nums[i % len];
            }
            stack.push(i % len);
        }
        return res;
    }
}
