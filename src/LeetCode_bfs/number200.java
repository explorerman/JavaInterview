package LeetCode_bfs;

import java.util.LinkedList;

public class number200 {

    /**
     * BFS和DFS经常可以解决相同的问题
     * 在遍历’1‘的时候，且该位置没有被访问过，则调用一个BFS，借助队列queue完成。
     * 将当前位置加入队列，然后进行while循环，将队首元素提取出来，并遍历其四周，若没有
     * 越界的话，则将visited中该邻居位置标记为true，并将其加入队列中等待下次遍历。
     * @param args
     */
    public int numIslands(char[][] grid){
        if(grid.length == 0) return 0;
//		int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; // 4 * 2维矩阵
        /*或者定义两个一维坐标，最终目的都是为了向四个方向扩散
         * 				x,y+1
         * 		x-1,y	x,y     x+1,y
         * 				x,y-1
         */
        int[] dirX = {-1,0,1,0};
        int[] dirY = {0,-1,0,1};
        int m = grid.length;   //横坐标
        int n = grid[0].length;   //纵坐标
        int res = 0;
        boolean[][] visited = new boolean[m][n];
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '0' || visited[i][j])  continue;
                res++;
                queue.addLast(i * n + j);  //转化为数字代表坐标
                visited[i][j] = true;
                while(!queue.isEmpty()){
                    int cur = queue.removeFirst();
                    int curX = cur / n;  //因为上面把坐标转化为了数字，所以这边通过取整获得横坐标
                    int curY = cur % n;  //通过取余获得纵坐标
                    //获得四个方向上的坐标
                    for(int k = 0; k < 4; k++){
//						int newX = curX + directions[k][0];
//						int newY = curY + directions[k][1];
                        int newX = curX + dirX[k];
                        int newY = curY + dirY[k];
                        if(newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] =='1' && !visited[newX][newY]){
                            queue.addLast(newX * n + newY);
                            visited[newX][newY] = true;
                        }
                    }
                }
            }
        }
        return res;
    }
//	private boolean inArea(int x, int y) {
//        // 等于号这些细节不要忘了
//        return x >= 0 && x < rows && y >= 0 && y < cols;
//    }

    public static void main(String[] args) {
    }
}
