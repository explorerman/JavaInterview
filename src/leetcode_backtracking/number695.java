package leetcode_backtracking;

//岛屿的最大面积2
public class number695 {
    //找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
    static int res = 0;
    public static int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        if(m > 50 && n > 50) return 0;
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != 1) continue;
                helper(grid,i,j);
                maxArea = Math.max(res, maxArea);
                res = 0;
            }
        }
        return maxArea == Integer.MIN_VALUE ? 0 : maxArea;
    }
    public static void helper(int[][] grid, int x, int y){

        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] <= 0){
            return ;
        }
        res++;
//			maxArea = Math.max(maxArea, res++);
        grid[x][y] = -1;
        helper(grid, x - 1, y);
        helper(grid, x + 1, y);
        helper(grid, x, y - 1);
        helper(grid, x, y + 1);
    }
    public static void main(String[] args) {
        int[][] res = {{1,1,1,0},{1,0,0,1}};
        int i = maxAreaOfIsland(res);
        System.out.println(i);

    }
}
