package LeetCode_byte_dance;

/**
 * @author 李杰
 * @version 1.0
 * @Description 岛屿数量
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/5/8 12:28
 * @title 标题: 岛屿数量
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number200 {
    int[] px = new int[]{-1, 0, 1, 0};
    int[] py = new int[]{0, -1, 0, 1};

    public int numIslands(char[][] grid) {
        int row = grid.length;
        if (row < 0) return 0;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    DFShelper(grid, visited, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void DFShelper(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < grid.length || i >= grid[0].length || j < grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == '0') {
            return;
        }
        visited[i][j] = true;
        for (int k = 0; k != 4; k++) {
            DFShelper(grid, visited, i + px[k], j + py[k]);
        }
    }

}
