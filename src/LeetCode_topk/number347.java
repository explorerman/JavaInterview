package LeetCode_topk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 前K个高频元素
public class number347 {
    //思路：利用hashmap来统计出现的次数，然后排序判断。
    public List<Integer> topKFrequent(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (!map.containsKey(nums[i])) {
//                map.put(nums[i], 1);
//            } else {
//                map.put(nums[i], map.get(nums[i]) + 1);
//            }
//        }
        // 统计每个数出现的次数
        for (Integer i : nums)  {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        //拉链的结构，list数组中每一个位置为这个数出现的次数 值为出现次数这么多的数
        List<Integer>[] temp = new List[nums.length +1];
        for (int key : map.keySet()) {
            // 出现的次数
            int i = map.get(key);
            if(temp[i] == null){
                temp[i] = new ArrayList<>();
            }
            // 当前次数中 包含那些数
            temp[i].add(key);
        }
        for(int i = temp.length-1; i >= 0 && list.size() < k; i--){
            if(temp[i] == null) continue;
            // 该题没有出现频率相同的数字 不需要考虑其他情况
            list.addAll(temp[i]);
        }
        return list;
    }
}
