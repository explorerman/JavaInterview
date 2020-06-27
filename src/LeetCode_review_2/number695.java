package LeetCode_review_2;

public class number695 {
    //定义访问数组，标记是否走过该节点
    boolean[][] visited;
    //判断每次访问岛屿时的节点数，也就是当层访问节点的岛屿数
    int res = 0;
    //横纵坐标
    int[] px = new int[]{-1,0, 1, 0};
    int[] py = new int[]{0,-1, 0, 1};
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        if(row == 0) return 0;
        int col = grid[0].length;
        visited = new boolean[row][col];
        //最后的结果
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    DFS(grid, visited, i, j);
                    maxArea = Math.max(maxArea, res);
                    res = 0;
                }
            }
        }
        return maxArea == Integer.MIN_VALUE ? 0 : maxArea;
    }
    private void DFS(int[][] grid, boolean[][] visited, int x, int y){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] || grid[x][y] == 0){
            return;
        }
        //每个节点做如下两个操作
        //1. 将走过的路标记为true，表示已走
        visited[x][y] = true;
        //2. 岛屿计数器加1
        res++;
        for(int i = 0; i != 4; i++){
            DFS(grid, visited, x + px[i], y + py[i]);
        }
    }
}
