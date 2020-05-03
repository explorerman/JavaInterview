package LeetCode_review_2;

//不同路径2
public class number63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        if(row == 0) return 0;
        int col = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) return 0;
        return helper(obstacleGrid , row - 1, col - 1);
    }

    int helper(int[][] obstacleGrid, int x, int y) {
        if(x < 0 || y < 0) return 0;
        if(x == 0 && y == 0 && obstacleGrid[x][y] != 1) return 1;
        if (obstacleGrid[x][y] == 1) {
            return 0;
        }
        int left = helper(obstacleGrid, x - 1, y);
        int right = helper(obstacleGrid, x, y - 1);
        return left + right;
    }
}
