package leetcode_tree;

import java.util.LinkedList;
import java.util.Queue;

//二叉树的最小深度
public class number111 {
    // 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
    // 说明: 叶子节点是指没有子节点的节点。
    //dfs解法
    public static int minDepth(TreeNode root) {
        if(root == null) return 0;
        int leftLength = minDepth(root.left) + 1;
        int rightLength = minDepth(root.right) + 1;
        if(root.right == null){
            return leftLength;
        }
        if(root.left == null){
            return rightLength;
        }
        return Math.min(leftLength,rightLength);
    }
    //bfs
    public static int minDepth2(TreeNode root){
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while(!queue.isEmpty()){
            count++;
            for(int i = queue.size(); i > 0; i--){
                TreeNode temp = queue.remove();
                if(temp.left == null && temp.right == null){
                    return count;
                }
                if(temp.left != null) {
                    queue.add(temp.left);
                }
                if(temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        System.out.println(minDepth2(n1));

    }
}
