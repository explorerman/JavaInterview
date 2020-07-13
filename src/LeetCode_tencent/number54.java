package LeetCode_tencent;

import java.util.ArrayList;
import java.util.List;

public class number54 {
    //难点1：循环的结束条件是啥
    //怎么控制横纵坐标
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int row = matrix.length;
        if (row <= 0) return res;
        int col = matrix[0].length;
        int left = 0, right = col - 1, top = 0, bottom = row - 1;
        while (left <= right && top <= bottom){
            //从四个方向走，每行或者每列走完，相应位置坐标记
            //1.先从左到右
            for (int i = left; i <= right; i++) {
                res.add(matrix[left][i]);
            }
            //首层走完了，也就是top往下挪一行
            top++;
            //走右边的纵列
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            //右边列走完了，往左挪一列
            right--;
            //右边走完了，要继续从底部的右边走到左边了
            //这时候需要判断，是否已经不满足条件了，譬如只有一行的时候，top这时候已经大于了bottom，可以直接return了
            if(top <= bottom){
                for (int i = right; i >= left ; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }else {
                break;
            }
            //继续从底向上了
            if(left <= right){
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }else {
                break;
            }
        }
    return res;
    }
}
