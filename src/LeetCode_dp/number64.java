package LeetCode_dp;
//最小路径和
public class number64 {
    //输入:
    //[
    //  [1,3,1],
    //  [1,5,1],
    //  [4,2,1]
    //]
    //输出: 7
    //路径最值问题优先考虑贪婪和动态规划
    //本题不能使用贪婪算法，因为贪婪算法是局部最优
    //使用dp二维数组
    public int minPathSum(int[][] grid) {
        int m = grid.length;                 //行
        int n = grid[0].length;              //列
        int[][] dp = new int[m][n];  //维护一个二维数组用于存储走到当前位置的最小路径和
        dp[0][0] = grid[0][0];     //dp的起点位置赋值和第一行，第一列要提前赋值
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];   //初始化第一列的值，dp的值只能从上面过来
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = grid[0][i] +  dp[0][i-1];     //初始化第一行的值，dp的值只能从左边过来
        }
        for (int i = 1; i < m; i++) {      //到达当前位置（i,j）只有两种情况：从i-1，j-1方向来，选择值小的值和grid[i][j]相加
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);   //dp转化方程，原数组的值+左边和上边元素的最小值
            }
        }
        return dp[m - 1][n -1];
    }

    //使用dp一维数组
    public int minPathSum2(int[][] grid) {
        int m = grid.length;                 //行
        int n = grid[0].length;              //列
        int[][] dp = new int[m][n];  //维护一个二维数组用于存储走到当前位置的最小路径和
        dp[0][0] = grid[0][0];     //dp的起点位置赋值和第一行，第一列要提前赋值
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];   //初始化第一列的值，dp的值只能从上面过来
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = grid[0][i] +  dp[0][i-1];     //初始化第一行的值，dp的值只能从左边过来
        }
        for (int i = 1; i < m; i++) {      //到达当前位置（i,j）只有两种情况：从i-1，j-1方向来，选择值小的值和grid[i][j]相加
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);   //dp转化方程，原数组的值+左边和上边元素的最小值
            }
        }
        return dp[m - 1][n -1];
    }
}
