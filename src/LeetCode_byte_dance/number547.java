package LeetCode_byte_dance;

/**
 * @author 李杰
 * @version 1.0
 * @Description 朋友圈
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/6/4 12:45
 * @title 标题: 朋友圈
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
//找对于某个人，遍历其好友，然后再遍历其好友的好友，那么就能把属于同一个朋友圈的人都遍历一遍，
// 同时标记出已经遍历过的人，
// 然后累积朋友圈的个数，再去对于没有遍历到的人在找其朋友圈的人，这样就能求出个数
public class number547 {
    public int findCircleNum(int[][] M) {
        int row = M.length;
        if (row <= 0) return 0;
        boolean[] visited = new boolean[row];
        int res = 0;
        for (int i = 0; i < row; i++) {
            if (visited[i]) continue;
            DFS(M, visited, i);
            res++;
        }
        return res;
    }

    private void DFS(int[][] grid, boolean[] visited, int i) {
        visited[i] = true;
        //因为M是正方形，所以j < grid.length 和 j < grid[0].length都可以
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == 0 || visited[j]) {
                continue;
            }
            DFS(grid, visited, j);
        }
    }
}
