import java.util.ArrayList;
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
        boolean[] visited = new boolean[candidates.length];
        combinationSum2DFS(res, new ArrayList<>(), candidates, target, visited);
        return res;
    }

    private void combinationSum2DFS(List<List<Integer>> res, ArrayList<Integer> level, int[] candidates, int target, boolean[] visited) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            res.add(new ArrayList<>(level));
        }
        for (int i = 0; i < candidates.length; i++) {
            if(visited[i] == true){
                continue;
            }
            visited[i] = true;
            level.add(candidates[i]);
            //进入下一轮决策
            combinationSum2DFS(res, level, candidates, target - candidates[i], visited);
            visited[i] = false;
            //取消选择
            level.remove(level.size() - 1);
        }
    }
}
