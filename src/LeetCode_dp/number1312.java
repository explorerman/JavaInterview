package LeetCode_dp;

/**
 * @author 李杰
 * @version 1.0
 * @Description 让字符串成为回文串的最少插入次数
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/7/30 12:27
 * @title 标题: 让字符串成为回文串的最少插入次数
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number1312 {
    //思路：将字符串逆序，然后比较两个字符串的公共子序列，最后用长度-最长的公共子序列即为最小的插入次数
    public int minInsertions(String s) {
        StringBuilder sb = new StringBuilder(s);
        final String reverseS = sb.reverse().toString();
        //求，s和reverseS的公共子序列
        int maxNum = longestCommonSubsequence(s, reverseS);
        return s.length() - maxNum;
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

    public static void main(String[] args) {
        new number1312().minInsertions("abc");
    }
}
