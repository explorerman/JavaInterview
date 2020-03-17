package leetcode_backtracking;

import java.util.ArrayList;
import java.util.List;

public class number39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates.length == 0 || target < 0) return res;
        combinationSumDFS(res, new ArrayList<Integer>(), 0, candidates, target);
        return res;
    }

    private void combinationSumDFS(List<List<Integer>> result, ArrayList<Integer> level, int start, int[] candidates, int target) {
        if (target < 0) return;
        if(target == 0){
            result.add(new ArrayList<>(level));
        }
        for (int i = start; i < candidates.length; i++){
            level.add(candidates[i]);
            combinationSumDFS(result, level, i, candidates, target - candidates[i]);
            level.remove(level.size() -1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        new number39().combinationSum(candidates, 7);
    }
}
