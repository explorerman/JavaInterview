package LeetCode_array;

/**
 * @author 李杰
 * @version 1.0
 * @Description 旋转图像
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/7/28 15:59
 * @title 标题: 旋转图像
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number48 {
    //因为旋转，所以先转置，再逐行交换元素
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        if(row <= 0) return;
        int col = matrix[0].length;
        //转置
        for (int i = 0; i < row; i++) {
            for (int j = i; j < col; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //交换，需要找到每行交换的规律
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][row - j - 1];
                matrix[i][row - j - 1] = temp;
            }
        }
    }
}

