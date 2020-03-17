package LeetCode_greedy;

import java.util.*;

public class number406 {
    //[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
    //
    //输出:
    //[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
    //
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        List<int[]> output = new LinkedList<>();
        for(int[] p : people){
            output.add(p[1], p);
        }
        int n = people.length;
        return output.toArray(new int[n][2]);
    }
    public static void sort(int[][] ob, int[] order) {
        Arrays.sort(ob, new Comparator<Object>() {
            public int compare(Object o1, Object o2) {
                int[] one = (int[]) o1;
                int[] two = (int[]) o2;
                for (int i = 0; i < order.length; i++) {
                    int k = order[i];
                    if (one[k] > two[k]) {
                        return 1;
                    } else if (one[k] < two[k]) {
                        return -1;
                    } else {
                        continue;  //如果按一条件比较结果相等，就使用第二个条件进行比较。
                    }
                }
                return 0;
            }
        });
    }

    public static void main(String[] args) {
        int array[][] = new int[][] {
                { 7,0 },
                { 4,4},
                { 7,1},
                { 5,0},
                { 6,1 },
                { 5,2 },};

    }

}
