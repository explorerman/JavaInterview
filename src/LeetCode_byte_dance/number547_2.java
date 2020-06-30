package LeetCode_byte_dance;

/**
 * @author 李杰
 * @version 1.0
 * @Description 朋友圈, 使用union find做
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/6/4 12:45
 * @title 标题: 朋友圈
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */

public class number547_2 {
    public int findCircleNum(int[][] M) {
        int row = M.length;
        int res = 0;
        boolean[] visited = new boolean[row];
        for(int index = 0; index < row; index++){
            //寻找没有访问过的学生
            if(visited[index] == false){
                res++;
                visited[index] = true;//标记访问
                DFS(M, visited, index);//深度遍历index所在的朋友圈中的所有朋友
            }
        }
        return res;
    }
    //访问所有在nowIndex所在的朋友圈中还未访问的朋友
    private void DFS(int[][] M, boolean[] visited, int nowIndex){
        int row = M.length;
        //穷举所有的学生
        for(int index = 0; index < row; index++){
            //nowIndex与index是朋友，且index没有访问过
            if(M[nowIndex][index] == 1 && visited[index] == false){
                visited[index] = true;//标记访问
                DFS(M,visited, index);//深度遍历index的朋友
            }
        }
    }

}
