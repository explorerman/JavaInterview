package LeetCode_byte_dance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class number56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int row = intervals.length;
        if(row == 0) return new int[0][0];
        int col = intervals[0].length;
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < row - 1 && right >= intervals[i + 1][0]){
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            res.add(new int[]{left, right});
        }
        final int[][] ress = res.toArray(new int[0][]);
        return ress;
    }
}
