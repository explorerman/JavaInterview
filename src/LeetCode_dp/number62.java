package LeetCode_dp;

import java.util.Arrays;

//不同路径
public class number62 {
    //输入: m = 3, n = 2
    //输出: 3
    //解释:
    //从左上角开始，总共有 3 条路径可以到达右下角。
    //1. 向右 -> 向右 -> 向下
    //2. 向右 -> 向下 -> 向右
    //3. 向下 -> 向右 -> 向右

    //二维数组
    public int uniquePaths(int m, int n) {
        //状态转移方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1; //初始化列
        for (int i = 0; i < m; i++) dp[i][0] = 1;  //初始化行
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    //一维数组
    public int uniquePaths2(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1] ;
            }
        }
        return cur[n-1];
    }
    public static void main(String[] args) {
        new number62().uniquePaths2(3,2);
    }
}
