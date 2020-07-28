package leetcode_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李杰
 * @version 1.0
 * @Description 求跟到叶子节点数字之和
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/7/28 9:47
 * @title 标题: 求跟到叶子节点数字之和
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number129 {
    List<String> list = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        dfs(root, "");
        int res = 0;
        for (String cur: list) {
            res += Integer.valueOf(cur);
        }
        return res;
    }

    private void dfs(TreeNode root, String level) {
        if(root.left == null && root.right == null){
            level += root.val;
            list.add(level);
            return;
        }
        level += root.val;
        if(root.left != null) dfs(root.left, level);
        if(root.right != null) dfs(root.right, level);
    }
}
