package LeetCode_dp;

import org.apache.xmlbeans.impl.jam.mutable.MAnnotatedElement;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 李杰
 * @version 1.0
 * @Description 打家劫舍3
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/7/16 9:36
 * @title 标题: 打家劫舍3
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number337 {
    //使用BFS来求解：求解奇偶层的值
    public int rob(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int odd = 0, even = 0,level = 1;
        queue.offer(root);
        while (!queue.isEmpty()){
            for (int i = queue.size(); i > 0; i--) {
                final TreeNode node = queue.poll();
                if(level % 2 == 0){
                    even += node.val;
                }else {
                    odd += node.val;
                }
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            level++;
        }
        return Math.max(odd,even);
    }
}
