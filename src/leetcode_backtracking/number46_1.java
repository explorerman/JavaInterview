package leetcode_backtracking;

import java.util.ArrayList;
import java.util.List;

public class number46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0 || nums == null){
            return res;
        }
        permuteDFS(res,new ArrayList<>(),nums);
        return res;
    }
    private void permuteDFS(List<List<Integer>> result, ArrayList<Integer> levelList, int[] nums){
        if(levelList.size() == nums.length){
            result.add(new ArrayList<>(levelList));
            return;
        }
        for(int i = 0; i<nums.length;i++){
            if(levelList.contains(nums[i])){
                continue;
            }
            levelList.add(nums[i]);
            permuteDFS(result,levelList,nums);
            levelList.remove(levelList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        new number46().permute(nums);
    }
}
