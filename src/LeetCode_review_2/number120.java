package LeetCode_review_2;

import java.util.List;

//三角形最小路径和
//第一步：回溯求解，暴力破解
public class number120 {
    int row;
    public int minimumTotal(List<List<Integer>> triangle) {
        row = triangle.size() - 1;
        return helper(0,0,triangle);
    }
    int helper(int level, int index, List<List<Integer>> triangle){
        if(level == row){
            return triangle.get(level).get(index);
        }
        int left = helper(level + 1, index, triangle);
        int right = helper(level + 1, index + 1, triangle);
        return Math.min(left, right) + triangle.get(level).get(index);
    }



}
