package LeetCode_review_2;

//不同路径2
public class number63_3 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        if(row == 0) return 0;
        int col = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[row+1][col+1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col ; j++) {
                if(i == 1 && j == 1 && obstacleGrid[i-1][j-1] != 1){
                    dp[1][1] = 1;
                }else if(obstacleGrid[i-1][j-1] != 1){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return dp[row][col];
    }

}
