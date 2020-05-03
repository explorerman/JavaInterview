package LeetCode_review_2;

import java.util.List;

//三角形最小路径和
//自顶向下，记忆化搜索。
public class number120_2 {
    int row;
    Integer[][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
        row = triangle.size();
        memo = new Integer[row][row];
        return helper(0,0,triangle);
    }
    int helper(int level, int index, List<List<Integer>> triangle){
        if(memo[level][index] != null){
            return memo[level][index];
        }
        if(level == row - 1){
//            return triangle.get(level).get(index); 可以直接这么写。
            return memo[level][index] = triangle.get(level).get(index);
        }
        int left = helper(level + 1, index, triangle);
        int right = helper(level + 1, index + 1, triangle);
        return memo[level][index] = Math.min(left, right) + triangle.get(level).get(index);
    }



}
