package LeetCode_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 李杰
 * @version 1.0
 * @Description 在每个树行中找最大值
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/8/7 15:01
 * @title 标题: 在每个树行中找最大值
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number515 {
    //层次遍历比较好做些，直接找到每层的最大值
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> largestList = new ArrayList<>();
        if(root == null) return largestList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            largestList.add(conputeMaxNum(queue));
            for (int i = queue.size(); i > 0 ; i--) {
                TreeNode cur = queue.poll();
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
        }
        return largestList;
    }

    private Integer conputeMaxNum(Queue<TreeNode> queue) {
        int max = Integer.MIN_VALUE;
        for (TreeNode cur : queue) {
            max = Math.max(max, cur.val);
        }
        return max;
    }
}
