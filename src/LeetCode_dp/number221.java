package LeetCode_dp;

public class number221 {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if (row <= 0) return 0;
        int col = matrix[0].length;
        int maxSide = 0;
        // dp(i, j)表示以 (i, j)为右下角，且只包含 1 的正方形的边长最大值
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
