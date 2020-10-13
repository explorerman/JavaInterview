import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//回溯法——排列问题(数组中有重复元素，需要去重)
// 1,1,2
public class number47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        //使用visited可以防止有重复数字的全排列，0是未访问，1是访问
        int[] visited = new int[nums.length];
        Arrays.sort(nums);
        permuteDFS(res,new ArrayList<Integer>(),nums, visited);
        return res;
    }
    private void permuteDFS(List<List<Integer>> result, ArrayList<Integer> levelList, int[] nums, int[] visited){
        if(levelList.size() == nums.length){
            result.add(new ArrayList<>(levelList));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            //已访问过，跳出循环
            if (visited[i] == 1) continue;
            //如果数组相连元素相等，没有先访问后面的元素，就不会存在重复
            if(i>0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) continue;
            visited[i] = 1;
            //做选择
            levelList.add(nums[i]);
            //进入下一层决策树
            permuteDFS(result,levelList,nums, visited);
            //撤销
            visited[i] = 0;
            //取消选择
            levelList.remove(levelList.size() - 1);
        }
    }

    public static void main(String[] args) {
        new number47().permuteUnique(new int[]{1,1,2});
    }
}
