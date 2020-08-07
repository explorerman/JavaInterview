package leetcode_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 李杰
 * @version 1.0
 * @Description 二叉树的序列化与反序列化
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/8/7 14:58
 * @title 标题: 二叉树的序列化与反序列化
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number297 {
    // Encodes a tree to a single string.
    //序列化活的结果为：“根∣(根∣(根∣左∣右)∣(根∣左∣右))∣(根∣(根∣左∣右)∣(根∣左∣右))”
    //1,X,X,2,X,X,3,4,X,X,5,X,X
    public String serialize(TreeNode root) {
        if (root == null) return "X,";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        String res = "";
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll(); // 考察出列的节点
            if (node != null) {                 // 是真实节点，带出子节点入列
                res += node.val + ",";
                queue.offer(node.left);    // 不管是不是null节点都入列
                queue.offer(node.right);
            } else {                    // 是null节点
                res += "X,";
            }
        }
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 就一个'X'，只有一个null
        if(data.equals("X,")) return null;
        // 序列化字符串转成list数组
        String[] list = data.split(",");
        // 首项是根节点值，为它创建root节点
        TreeNode root = new TreeNode(Integer.valueOf(list[0]));
        // 起初root入列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 从list第二项开始遍历
        int index = 1;
        while (index < list.length){
            //考察出列的节点
            TreeNode cur = queue.poll();
            // 获取它的左子节点的值
            String leftValue = list[index];
            // 获取它的右子节点的值
            String rightValue = list[index + 1];
            if(!leftValue.equals("X")){
                // 创建左子节点
                TreeNode left = new TreeNode(Integer.valueOf(leftValue));
                // 成为父节点的左子节点
                cur.left = left;
                // 它本身是未来的爸爸，入列
                queue.offer(left);
            }
            if(!rightValue.equals("X")){
                TreeNode right = new TreeNode(Integer.valueOf(rightValue));
                cur.right = right;
                queue.offer(right);
            }
            // 指针前进2位
            index += 2;
        }
        return root;
    }
}
