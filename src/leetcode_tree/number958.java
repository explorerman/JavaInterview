package leetcode_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 李杰
 * @version 1.0
 * @Description 二叉树的完全性检验
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/7/24 13:50
 * @title 标题: 二叉树的完全性检验
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number958 {
    //两个条件：左右子树高度差不超过1，并且所有叶节点，要不左右子树为空，要不只有左孩子，不能只有有孩子
    //判断当前队列中的null的位置，如果是完全二叉树，则null应该出现在末尾，如果出现null的时候，后面还有数字，则不是完全二叉树
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode pre = root;
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(pre == null && cur != null){
                return false;
            }
            if(cur != null){
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
            pre = cur;
        }
        return true;
    }
}
