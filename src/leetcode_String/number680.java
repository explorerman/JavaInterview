package leetcode_String;

/**
 * @author 李杰
 * @version 1.0
 * @Description 验证回文字符串2
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/8/11 15:31
 * @title 标题: 验证回文字符串2
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number680 {
    //这种回文串问题，都可以转成dp的最长公共子串问题,但超出了内存限制
    public boolean validPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        String reverseStr = sb.reverse().toString();
        final int num = longestCommonSubsequence(s, reverseStr);
        int res = s.length() - num;
        if(res <= 1) return true;
        else return false;
    }
    private int longestCommonSubsequence(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 == 0 || len2 == 0 || str1 == null || str2 == null) return 0;
        //构造一个二维dp
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                //如果两个字符相同，则取左上角的值+1
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    //否则，取左边或者上边的最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}

