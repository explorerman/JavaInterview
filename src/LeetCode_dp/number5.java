package LeetCode_dp;

//最长回文字串

/**
 * 三种解决：
 * 1.根据回文串特性，中间节点开始往左右找，回文串分奇数和偶数
 * 1.1 不使用额外的方法来解决
 * 2.dp,思想是：利用上一次找到的回文串的结果，来进行下一步操作
 * 3.马拉车算法，优点是将时间复杂度提升到线性时间复杂度。
 */
public class number5 {
    public static String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        int n = s.length(), start = 0, maxLen = 0;
        for (int i = 0; i < n - 1; ++i) {
            searchPalindrome(s, i, i, start, maxLen);
            searchPalindrome(s, i, i + 1, start, maxLen);
        }
        return s.substring(start, start + maxLen);
    }

    static void searchPalindrome(String s, int left, int right, int start, int maxLen) {
        System.out.println("start  left = " + left + " right = " + right + " start = " + start + " maxlen = " + maxLen);
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        if (maxLen < right - left - 1) {
            start = left + 1;
            maxLen = right - left - 1;
        }
        System.out.println("end  left = " + left + " right = " + right + " start = " + start + " maxlen = " + maxLen);
        System.out.println();
    }

    public static String longestPalindrome2(String s) {
        if (s.length() < 2) return s;
        //maxLen记录最长的回文串
        int n = s.length(), start = 0, maxLen = 0;
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < n; ) {
            if (n - i <= maxLen / 2) break;
            int left = i, right = i;
            while (right < n - 1 && s.charAt(right) == s.charAt(right + 1)) {
                right++;
            }
            i = right + 1;
            while (left > 0 && right < n - 1 && s.charAt(left - 1) == s.charAt(right + 1)) {
                --left;
                ++right;
            }
            if (maxLen < right - left + 1) {
                maxLen = right - left + 1;
                start = left;
            }
        }
        System.out.println(System.currentTimeMillis() - startTime + "s");
        return s.substring(start, start + maxLen);
    }

    public static String longestPalindrome_dp(String s) {
//        int n = s.length();
//        if (n < 2) return s;
//        int left = 0, len = 1;
//        int[][] dp = new int[n][n];
//        Arrays.fill(dp,false);
//        for (int i = 0; i < n; ++i) {
//            dp[i][i] = 1;
//            for (int j = 0; j < i; ++j) {
//                dp[j][i] = (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1]));
//                if (dp[j][i] && len < i - j + 1) {
//                    len = i - j + 1;
//                    left = j;
//                }
//            }
//        }
//        return s.substring(left, left + len);

        return "";
    }



    public static void main(String[] args) {
        System.out.println(longestPalindrome2("acc"));
    }
}
