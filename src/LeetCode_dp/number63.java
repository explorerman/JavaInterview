package LeetCode_dp;

public class number63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;     //行
        int n = obstacleGrid[0].length;    //列
        if(m == 0 || n == 0 || obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[m + 1][n + 1];  //是为了考虑边缘情况，当i或者j为0时，减1可能会出错，dp[i][j]表示到达（i-1,j-1）位置的不同路径，所以ij的范围是【1，m】【1,n】

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[0][1] = 1;       //当起点不是障碍物时，其dp值应该为1，dp[1][1] = 1,根据转换方程，只需要初始化dp[0][1]或者dp[1][0]为1即可
                if(obstacleGrid[i -1][j - 1] != 0)  //当某个位置是障碍物时，其dp值为0，直接跳过该位置
                {
                    continue;
                }
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];     //因为每个位置只能由其上面和左面的位置移动而来，所以dp转换方程如左
            }
        }
        return dp[m][n];
    }
}
