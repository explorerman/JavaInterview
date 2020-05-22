package LeetCode_byte_dance;

public class formal02 {
    //岛屿问题 （图的遍历）
    int[] px = new int[]{-1, 0, 1, 0};
    int[] py = new int[]{0, 1, 0, -1};
    public int numIslands(char[][] grid){
        int row = grid.length;
        if(row == 0) return 0;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == '0' || visited[row][col] == true) continue;
                DFS(grid, visited, i, j);
                res++;
            }
        }
        return res;
    }

    private void DFS(char[][] grid, boolean[][] visited, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] == true || grid[i][j] == '0'){
            return;
        }
        visited[i][j] = true;
        for (int k = 0; k != 4 ; k++) {
            DFS(grid, visited, i + px[k], j + py[k]);
        }
    }
}
