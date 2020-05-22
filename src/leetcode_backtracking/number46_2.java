package leetcode_backtracking;

import java.util.ArrayList;
import java.util.List;

public class number46_2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        boolean[] visited = new boolean[nums.length];
        permuteDFS(res,new ArrayList<Integer>(),nums, visited);
        return res;
    }
    private void permuteDFS(List<List<Integer>> result, ArrayList<Integer> levelList, int[] nums, boolean[] visited){
        if(levelList.size() == nums.length){
            result.add(new ArrayList<>(levelList));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if (visited[i] == true) continue;
            visited[i] = true;
            levelList.add(nums[i]);
            permuteDFS(result,levelList,nums, visited);
            visited[i] = false;
            levelList.remove(levelList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        new number46_2().permute(nums);

    }



}
