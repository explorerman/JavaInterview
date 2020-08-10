package LeetCode_array;

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
public class number503_1 {
    //输入: [1,2,1]  1,2,1,1,2,1
    //输出: [2,-1,2] res =    2,-1,-1
    //使用单调栈
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len]; //存放结果
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * len - 1; i >= 0; --i) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % len]) {
                stack.pop();
            }
            res[i % len] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % len);
        }
        return res;
    }
}
