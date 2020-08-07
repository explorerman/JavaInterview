package leetcode_tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 李杰
 * @version 1.0
 * @Description 二叉树的序列化与反序列化，使用DFS的解法
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/8/7 14:58
 * @title 标题: 二叉树的序列化与反序列化
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number297_1 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //遇到null节点
        if (root == null) return "x,";
        //左子树的序列化结果
        String leftSerialized = serialize(root.left);
        //右子树的序列化结果
        String rightSerialized = serialize(root.right);
        //按前序遍历的结果拼接，根左右
        return root.val + "," + leftSerialized + rightSerialized;
    }

    // Decodes your encoded data to tree.

    /**
     * 构建树的函数 buildTree 接收的 “状态” 是 list 数组，由序列化字符串转成
     * 按照前序遍历的顺序：先构建根节点，再构建左子树、右子树
     * 将 list 数组的首项弹出，它是当前子树的 root 节点
     * 如果它为 'X' ，返回 null
     * 如果它不为 'X'，则为它创建节点，并递归调用 buildTree 构建左右子树，当前子树构建完毕，向上返回
     */
    public TreeNode deserialize(String data) {
        String[] list = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(list));
        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> queue) {
        //弹出首项
        String cur = queue.poll();
        if(cur.equals("x")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(cur));
        //构建左子树
       node.left = buildTree(queue);
        //构建右子树
        node.right = buildTree(queue);
        return node;
    }
}
