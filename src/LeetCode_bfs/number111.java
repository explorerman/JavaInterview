package LeetCode_bfs;

import java.util.LinkedList;
import java.util.Queue;

//二叉树的最小深度
public class number111 {
    int minDepth(TreeNode root){
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //root本身就是一层，初始化为1
        int dept = 1;
        while (!queue.isEmpty()){
            //queue的size必须在for中或者前初始化好
            final int size = queue.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < size; i++) {
                final TreeNode node = queue.poll();
                /* 判断是否到达终点 */
                if(node.left == null && node.right == null){
                    return dept;
                }
                /* 将 cur 的相邻节点加入队列 */
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            /* 这里增加步数 */
            dept++;
        }
        return dept;
    }
}
