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
        int col = matrix[0].length;
        int maxSide = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    maxSide = Math.max(maxSide, 1);
                    int currentMaxSide = Math.min(row - i, col - j);
                    for (int k = 1; k < currentMaxSide; k++) {
                        if (matrix[i + k][j + k] == '0') {
                            break;
                        }
                        boolean flag = true;
                        for (int m = 0; m < k; m++) {
                            if (matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        if(flag){
                            maxSide = Math.max(maxSide, k + 1);
                        }else {
                            break;
                        }
                    }
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }
}
