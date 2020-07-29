package LeetCode_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 李杰
 * @version 1.0
 * @Description 矩阵置零
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/7/29 16:01
 * @title 标题: 矩阵置零
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number73_1 {
    //两次遍历，第一次遍历的时候，将二维数组中的0找出来，并记录出横纵坐标
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        if (row <= 0) return;
        int col = matrix[0].length;
        List<List<Integer>> res = new ArrayList<>();
        //找到数组中的0，单独找是因为如果一次遍历，会使得后面置为0的行列也发生置换，所以先找出满足条件的值
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        //遍历list，将list中的横纵坐标对应的行列赋值为0
        for (List<Integer> list : res) {
            for (int i = 0; i < col; i++) {
                matrix[list.get(0)][i] = 0;
            }
            for (int i = 0; i < row; i++) {
                matrix[i][list.get(1)] = 0;
            }
        }
    }
}
