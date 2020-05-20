package LeetCode_face01;

import java.util.Map;
import java.util.TreeMap;

public class StreamRank {
    private TreeMap<Integer, Integer> data;

    public StreamRank() {
        data = new TreeMap<>();
    }

    public void track(int x) {
        data.compute(x, (k, v) -> v == null ? 1 : v + 1);
    }

    public int getRankOfNumber(int x) {
        if (data.isEmpty() || data.firstKey() > x) {
            return 0;
        }

        int sum = 0;
        // 严小于等于x的个数之和
        for (Map.Entry<Integer, Integer> entry : data.headMap(x, true).entrySet()) {
            sum += entry.getValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        StreamRank obj = new StreamRank();
        obj.track(20);
        int param_2 = obj.getRankOfNumber(20);
        System.out.println(param_2);
    }

}
