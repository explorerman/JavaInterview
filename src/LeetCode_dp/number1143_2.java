package LeetCode_dp;

//最长公共子序列
public class number1143_2 {
    //暴力破解
    //text1 = "abcde", text2 = "ace"
    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) return 0;
        int len1 = text1.length();
        int len2 = text2.length();
        //dp方程：初始化为长度+1，是因为右下角的值要与坐上角比较，如果初始化为长度时，在第一步的时候，会发生数组越界
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1 ; i++) {
            for (int j = 1; j <= len2; j++) {
                //dp方程：如果两个字符串字符相同，当前位置的值等于左上角的值+1
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    //
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }


    public static void main(String[] args) {
        longestCommonSubsequence("ezupkr", "ubmrapg");
    }
}
