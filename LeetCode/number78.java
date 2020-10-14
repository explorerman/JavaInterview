import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 李杰
 * @Description 子集，不含重复元素   组合问题--不包含重复元素
 */
public class number78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int depth = 0;
        subsetsDFS(res, depth, new ArrayList<Integer>(), nums);
        return res;
    }

    //方法1：
    private void subsetsDFS(List<List<Integer>> result, int startIndex, ArrayList<Integer> level, int[] nums) {
        result.add(new ArrayList<>(level));
        for (int i = startIndex; i < nums.length; i++) {
            if (level.size() == 0 || level.get(level.size() - 1) < nums[i]) {
                level.add(nums[i]);
                subsetsDFS(result, startIndex + 1, level, nums);
                level.remove(level.size() - 1);
            }
        }
    }

    //方法2：追加元素的方法：逐个枚举，空集的幂集只有空集，每增加一个元素，让之前幂集中的每个集合，追加这个元素，就是新增的子集。
    public static List<List<Integer>> enumerate(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (Integer n : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSub = new ArrayList<Integer>(res.get(i));
                newSub.add(n);
                res.add(newSub);
            }
        }
        return res;
    }

    // 方法3：集合的每个元素，都有可以选或不选，用二进制和位运算，可以很好的表示。
    public static List<List<Integer>> binaryBit(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < (1 << nums.length); i++) {    //左移位：相当于1 * 2 ^ nums.length
            List<Integer> sub = new ArrayList<Integer>();
            for (int j = 0; j < nums.length; j++)
                if (((i >> j) & 1) == 1) sub.add(nums[j]);        //右移位：i / 2 ^ j 然后与1,最后一位为1，则为1，为0则为0
            res.add(sub);
        }
        return res;
    }
}
