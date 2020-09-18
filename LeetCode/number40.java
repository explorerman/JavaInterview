import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//回溯法——组合问题（元素不可重复，需要去重）
public class number40 {
    // 输入: candidates = [10,1,2,7,6,1,5], target = 8,
    //所求解集为:
    //[
    //  [1, 7],
    //  [1, 2, 5],
    //  [2, 6],
    //  [1, 1, 6]
    //]
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates.length == 0 || target < 0) return res;
        // 关键步骤
        Arrays.sort(candidates);
        combinationSum2DFS(res, new ArrayList<Integer>(), 0, candidates, target);
        return res;
    }
    private void combinationSum2DFS(List<List<Integer>> result, ArrayList<Integer> level, int start, int[] candidates, int target) {
        if(target == 0){
            result.add(new ArrayList<>(level));
        }
        for (int i = start; i < candidates.length; i++){
            //大剪枝
            if (target - candidates[i] < 0) {
                break;
            }
            //小剪枝
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            level.add(candidates[i]);
            combinationSum2DFS(result, level, i +1, candidates, target - candidates[i]);
            level.remove(level.size() -1);
        }
    }
}
