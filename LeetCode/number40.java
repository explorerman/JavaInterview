import java.util.ArrayList;
import java.util.List;

/**
 * @author 李杰
 * @version 1.0
 * @Description 组合总和2（数组中元素只能使用一次）
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/9/18 9:24
 * @title 标题: 组合总和2（数组中元素只能使用一次）
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
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
