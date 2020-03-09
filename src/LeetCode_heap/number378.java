package LeetCode_heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class number378 {
    //matrix = [
    //   [ 1,  5,  9],
    //   [10, 11, 13],
    //   [12, 13, 15]
    //],
    //k = 8,
    //
    //返回 13。
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = matrix[0][0];
        int right = matrix[row - 1][col - 1];
        while (left < right){
            int mid = left + (right - left) / 2;
            int count = findNotBiggerThanMid(matrix, mid, row, col);
            if(count < k){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
    private int findNotBiggerThanMid(int[][] matrix, int mid, int row, int col) {
        // 以列为单位找，找到每一列最后一个<=mid的数即知道每一列有多少个数<=mid
        int i = row - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < col) {
            if (matrix[i][j] <= mid) {
                // 第j列有i+1个元素<=mid
                count += i + 1;
                j++;
            } else {
                // 第j列目前的数大于mid，需要继续在当前列往上找
                i--;
            }
        }
        return count;
    }

    public static int kthSmallest2(int[][] matrix, int k) {
        int row = matrix.length; // 行数
        int col = matrix[0].length; // 列数
        int[] countForRow = new int[row]; // 每一行的指针
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(pq.size() < k){
                    pq.offer(matrix[i][j]);
                }else{
                    if(pq.peek() > matrix[i][j]){
                        pq.poll();
                        pq.offer(matrix[i][j]);
                    }
                }
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                { 1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}
        };
        kthSmallest2(matrix,8);
    }
}
