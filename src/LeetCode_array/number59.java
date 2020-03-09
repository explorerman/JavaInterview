package LeetCode_array;

import java.util.ArrayList;

public class number59 {
    public int[][] generateMatrix(int n) {
        int row = n;
        int col = n;
        int[][] res = new int[n][n];
        int count = 1;
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0, right = col - 1, top = 0, bottom = row - 1;
        while(left <= right && top <= bottom){
            for(int i = left; i <= right; i++){  //朝右走，直到最右边
                res[top][i] = count;
                count++;
            }
            top++;         //右边走完，往下移
            for(int i = top; i <= bottom; i++){    //最右边朝下走，直到最下边
                res[i][right] = count;
                count++;
            }
            right--;        //最右边走完后，右边往左移一位
            //解决矩阵只有一行出现回文的情况
            //如果上边小于等于小边，说明还没有行没走，如果大于，则直接break;
            if(top <= bottom){
                for(int i = right; i >= left; i--){
                    res[bottom][i] = count;
                    count++;
                }
                bottom--;
            }else{
                break;
            }
            //解决矩阵只有一列出现的回文,若左边大于右边，则说明列都走完了，直接break
            if(left <= right){
                for(int i = bottom; i >= top; i--){
                    res[i][left] = count;
                    count++;
                }
                left++;
            }else{
                break;
            }
        }

        return res;
    }
}
