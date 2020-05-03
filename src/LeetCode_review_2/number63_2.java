package LeetCode_review_2;

//不同路径2
public class number63_2 {
    int[][] memo;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        if(row == 0) return 0;
        int col = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) return 0;
        memo = new int[row][col];
        return helper(obstacleGrid , row - 1, col - 1);
    }

    int helper(int[][] obstacleGrid, int x, int y) {
        if(x < 0 || y < 0) return 0;
        if(x == 0 && y == 0 && obstacleGrid[x][y] != 1) return 1;
        if (obstacleGrid[x][y] == 1) {
            return 0;
        }
        if(memo[x][y] != 0){
            return memo[x][y];
        }
        int left = helper(obstacleGrid, x - 1, y);
        int right = helper(obstacleGrid, x, y - 1);
        memo[x][y] = left + right;
        return memo[x][y];
    }
}
