package LeetCode_byte_dance;

/**
 * @author 李杰
 * @version 1.0
 * @Description 最大正方形
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/7/1 16:22
 * @title 标题: 最大正方形
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number221_1 {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if(row <= 0) return 0;
        int col = matrix[0].length;
        int maxSide = 0;
        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if(matrix[i][j] == '1'){
                    if(i == 1 || j == 1){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
