package LeetCode_dp;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author 李杰
 * @version 1.0
 * @Description 最长有效括号
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/8/6 14:41
 * @title 标题: 最长有效括号
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number32 {
//    对于这种括号匹配问题，一般都是使用栈
//    我们先找到所有可以匹配的索引号，然后找出最长连续数列！
//    例如：s = )(()())，我们用栈可以找到，

//    位置 2 和位置 3 匹配，
//    位置 4 和位置 5 匹配，
//    位置 1 和位置 6 匹配，

//    这个数组为：2,3,4,5,1,6 这是通过栈找到的，我们按递增排序！1,2,3,4,5,6
//    找出该数组的最长连续数列的长度就是最长有效括号长度！
//    所以时间复杂度来自排序：O(nlogn)O(nlogn)。
//    接下来我们思考，是否可以省略排序的过程,在弹栈时候进行操作呢?
//    直接看代码理解!所以时间复杂度为：O(n)O(n)。

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
//        System.out.println(stack);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        System.out.println(res);
        return res;
    }


    public static void main(String[] args) {
        new number32().longestValidParentheses("()(()");
    }
}
