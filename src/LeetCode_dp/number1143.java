package LeetCode_dp;

//最长公共子序列
public class number1143 {
    //暴力破解
    //text1 = "abcde", text2 = "ace"
    public static int longestCommonSubsequence(String text1, String text2) {
        StringBuilder sb = new StringBuilder();
        final char[] str1 = text1.toCharArray();
        final char[] str2 = text2.toCharArray();
        int len1 = text1.length();
        int len2 = text2.length();
        int loop = Math.min(len1, len2);
        int preIndex = 0;
        if(len2 <= len1){
            for (int i = 0; i < len2; i++) {
                char first = str2[i];
                for (int j = 0; j < len1; j++) {
                    if(str1[j] == first){
                        if(j >= preIndex){
                            preIndex = j;
                            sb.append(first);
                            continue;
                        }
                    }
                }
            }
        }else {
            for (int i = 0; i < len1; i++) {
                char first = str1[i];
                for (int j = 0; j < len2; j++) {
                    if(str2[j] == first){
                        if(j >= preIndex){
                            preIndex = j;
                            sb.append(first);
                            continue;
                        }
                    }
                }
            }
        }
        System.out.println(sb.toString());

        return sb.length();
    }

    public static void main(String[] args) {
        longestCommonSubsequence("ezupkr", "ubmrapg");
    }
}
