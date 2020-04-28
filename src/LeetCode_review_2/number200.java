package LeetCode_review_2;

//岛屿数量
//floodfill算法（dfs）属于回溯
public class number200 {
    int[] px = new int[]{-1, 0, 1, 0};  //左右
    int[] py = new int[]{0, 1, 0, -1};  //上下

    //
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int row = grid.length;  //横坐标
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '0' || visited[i][j]) continue;
                DFS(grid, visited, i, j);
                res++;
            }
        }
        return res;
    }

    void DFS(char[][] grid, boolean[][] visited, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0' || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        for (int i = 0; i != 4; i++) {  //四个方向遍历
            DFS(grid, visited, x + px[i], y + py[i]);
            visited[x][y] = false;
        }
    }

}

