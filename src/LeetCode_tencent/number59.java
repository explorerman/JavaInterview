package LeetCode_tencent;

/**
 * @author 李杰
 * @version 1.0
 * @Description 螺旋矩阵2
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/7/13 18:12
 * @title 标题: 螺旋矩阵2
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n -1;
        int count = 0;
        while (left <= right && top <= bottom){
            for (int i = left; i <= right; i++) {
                count++;
                res[left][i] = count;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                count++;
                res[i][right] = count;
            }
            right--;
            if(top <= bottom){
                for (int i = right; i >= left ; i--) {
                    count++;
                    res[bottom][i] = count;
                }
                bottom--;
            }else {
                break;
            }
            if(left <= right){
                for (int i = bottom; i >= top ; i--) {
                    count++;
                    res[i][left] = count;
                }
                left++;
            }else {
                break;
            }
        }
        return res;
    }
}
