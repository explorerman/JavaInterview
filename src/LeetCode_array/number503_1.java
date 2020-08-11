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
    //输出: [2,-1,2] res = 2,-1,-1
    //使用单调栈，单调递减栈，如果当前值比栈顶元素大，则出栈，因为是递减栈，所以一直找到当前值小于栈顶的值，这个值也就是当前值后的第一个大的值
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        //存放结果，res数组会进行两次赋值，因为要构造循环数组，最终遍历完两倍数组后，取原数组长度的值即可，也就是二次赋值后的结果
        int[] res = new int[len];
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
