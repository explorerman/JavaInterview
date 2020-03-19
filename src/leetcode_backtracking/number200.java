package leetcode_backtracking;

//岛屿数量
public class number200 {

    /**
     * 思路：dfs,类似迷宫遍历的题目可以使用DFS和BFS
     * 本质是求矩阵中连续区域的个数，容易想到使用DFS，建立一个visited数组用来记录某个位置是否被访问过，对于一个
     * 为’1‘且未被访问过的位置，我们递归进入其上下左右位置上为’1‘的数，将其visited对应值赋为true，继续进入其所有
     * 相连的邻位置，这样可以将这个连通区域所有的数都找出来，并将其对应的visited中的值赋值为true，找完相邻区域后，
     * 我们将结果res自增1，然后我们在继续找下一个为’1‘且未被访问过的位置，直到遍历完整个数组。
     * @param grid
     * @return
     */

    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '0' || visited[i][j])  continue;
                helper(grid, visited,i,j);
                res++;
            }
        }
        return res;
    }
    public static void helper(char[][] grid, boolean[][] visited, int x, int y){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0' || visited[x][y]){
            return ;
        }
        visited[x][y] = true;
        helper(grid, visited,x - 1, y);
        helper(grid, visited,x + 1, y);
        helper(grid, visited,x, y - 1);
        helper(grid, visited,x, y + 1);
    }
    public static void main(String[] args) {

    }
    /**
     DFS用递归的形式，用到了栈结构，先进后出。
     BFS选取状态用队列的形式，先进先出。
     都是搜索的思想，穷竭列举所有的情况
     复杂度:DFS的复杂度与BFS的复杂度大体一致，不同之处在于遍历的方式与对于问题的解决出发点不同
     DFS适合于目标明确
     BFS适合大范围内的查找
     */


}
