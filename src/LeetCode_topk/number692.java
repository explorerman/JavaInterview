package LeetCode_topk;

import java.util.*;

//前K个高频单词
public class number692 {
    //思路：
    //O(NlogK)的关键在于堆的大小只能限定到k这么大，要使用最小堆实现。评论中很多使用最大堆，把全部元素放进堆中，是不符合要求的。
    //使用最小堆的麻烦之处在于，最后输出元素时，得逆序一下子才行。不然就是频率从小到大排序了
    //
    //Java中的优先队列是不限制数据大小的，如果要限定优先队列中有k个元素，得人工判定，不能无脑往进塞数据，那是O(NlogN)不是O(NlogK)
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> queue = new PriorityQueue<>(k, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (map.get(s1).equals(map.get(s2))) {
                    return s2.compareTo(s1);
                }
                return map.get(s1).compareTo(map.get(s2));
            }
        });

        for (String key : map.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else if (queue.comparator().compare(key, queue.peek()) > 0) {
                queue.poll();
                queue.add(key);
            }
        }

        String[] res = new String[k];

        for (int i = k - 1; i >= 0; i--) {
            res[i] = queue.poll();
        }

        return Arrays.asList(res);
    }
}
