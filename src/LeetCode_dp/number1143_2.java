package LeetCode_dp;

//最长公共子序列
public class number1143_2 {
    //暴力破解
    //text1 = "abcde", text2 = "ace"
    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) return 0;
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1 ; i++) {
            for (int j = 1; j <= len2; j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
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
