package LeetCode_array;

import java.util.ArrayList;
import java.util.List;

//螺旋矩阵
public class number54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0, right = col - 1, top = 0, bottom = row - 1;
        while(left <= right && top <= bottom){
            for(int i = left; i <= right; i++){  //朝右走，直到最右边
                list.add(matrix[top][i]);
            }
            top++;         //右边走完，往下移
            for(int i = top; i <= bottom; i++){    //最右边朝下走，直到最下边
                list.add(matrix[i][right]);
            }
            right--;        //最右边走完后，右边往左移一位
            //解决矩阵只有一行出现回文的情况
            //如果上边小于等于小边，说明还没有行没走，如果大于，则直接break;
            if(top <= bottom){
                for(int i = right; i >= left; i--){
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }else{
                break;
            }
            //解决矩阵只有一列出现的回文,若左边大于右边，则说明列都走完了，直接break
            if(left <= right){
                for(int i = bottom; i >= top; i--){
                    list.add(matrix[i][left]);
                }
                left++;
            }else{
                break;
            }
        }
        return list;
    }
}
