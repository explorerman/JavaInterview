package LeetCode_review_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//按照字符出现次数对字符串排序
public class number451 {
    public String frequencySort(String s) {
        //第一步：将s放入map中，key为当前字符，value为出现的次数
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char cur : s.toCharArray()){
            frequencyMap.put(cur, frequencyMap.getOrDefault(cur, 0) + 1);
        }

        //第二步：按照出现次数将map中的字符放入不同的桶
        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for (char cur : frequencyMap.keySet()){
            int f = frequencyMap.get(cur);
            if(buckets[f] == null){
                buckets[f] = new ArrayList<>();
            }
            buckets[f].add(cur);
        }
        //第三步：倒序排桶，并将元素全部放入结果集
        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0 ; i--) {
            if(buckets[i] == null){
                continue;
            }
            for (char cur : buckets[i]){
                for (int j = 0; j < i; j++) {
                    sb.append(cur);
                }
            }
        }
        return sb.toString();
    }
}
