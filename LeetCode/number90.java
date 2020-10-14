import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 李杰
 * @Description 子集2：包含重复元素   组合问题--包含重复元素
 */
public class number90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        DFS(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }

    //方法1：回溯法
    private void DFS(int[] nums, int start, ArrayList<Integer> level, List<List<Integer>> res) {
        res.add(new ArrayList<>(level));
        for (int i = start; i < nums.length; i++) {
            //与78子集仅仅这行的区别
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            level.add(nums[i]);
            DFS(nums, i + 1, level, res);
            level.remove(level.size() - 1);
        }
    }
}
