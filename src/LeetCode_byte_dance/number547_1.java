package LeetCode_byte_dance;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 李杰
 * @version 1.0
 * @Description 朋友圈,使用bfs做
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/6/4 12:45
 * @title 标题: 朋友圈
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */

public class number547_1 {
    public int findCircleNum(int[][] M) {
        int row = M.length;
        if(row == 0) return 0;
        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[row];
        for (int i = 0; i < row; i++) {
            if(visited[i]){
                continue;
            }
            queue.add(i);
            while (!queue.isEmpty()){
                int temp = queue.remove();
                visited[temp] = true;
                for (int j = 0; j < row; j++) {
                    if(M[temp][j] == 0 || visited[j]) continue;
                    queue.add(j);
                }
            }
            res++;
        }
        return res;
    }

}
