package LeetCode_bfs;

import java.util.LinkedList;
import java.util.Queue;

//完全二叉树的节点个数
//使用BFS直接求每层的长度
public class number222 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            res += queue.size();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode temp = queue.poll();
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
        }
        return res;
    }

    public int countNodes2(TreeNode root) {
        int res = 0;
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            res += levelSize;
            for (int i = levelSize; i > 0; i--) {
                TreeNode temp = queue.poll();
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
        }
        return res;
    }
}
