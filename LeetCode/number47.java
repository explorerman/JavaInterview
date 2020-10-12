import java.util.ArrayList;
import java.util.List;

//回溯法——排列问题(数组中有重复元素，需要去重)
public class number47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        //使用visited可以防止有重复数字的全排列
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
            //排除不合法的选择
            if (visited[i] == true) continue;
            visited[i] = true;
            //做选择
            levelList.add(nums[i]);
            //进入下一层决策树
            permuteDFS(result,levelList,nums, visited);
            //撤销
            visited[i] = false;
            //取消选择
            levelList.remove(levelList.size() - 1);
        }
    }
}
