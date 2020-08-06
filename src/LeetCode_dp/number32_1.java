package LeetCode_dp;

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
public class number32_1 {
//())(()
//    我们用 dp[i] 表示以 i 结尾的最长有效括号；
//    当 s[i] 为 (,dp[i] 必然等于 0，因为不可能组成有效的括号；
//            那么 s[i] 为 )
//            2.1 当 s[i-1] 为 (，那么 dp[i] = dp[i-2] + 2；
//            2.2 当 s[i-1] 为 ) 并且 s[i-dp[i-1] - 1] 为 (，那么 dp[i] = dp[i-1] + 2 + dp[i-dp[i-1]-2]；
//            时间复杂度：O(n)

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] + 2 : 2);
                } else if (s.charAt(i - 1) == ')' && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        new number32_1().longestValidParentheses("()(()");
    }
}
