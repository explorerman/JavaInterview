package LeetCode_review_2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李杰
 * @version 1.0
 * @Description
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/4/29 14:52
 * @title 标题:
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        //尝试每个数字作为根节点
        for (int i = start; i <= end; i++) {
            //得到所有可能的左子树
            List<TreeNode> left = helper(start, i - 1);
            //得到所有可能的右子树
            List<TreeNode> right = helper(i + 1, end);
            for (TreeNode a : left) {
                for (TreeNode b : right) {
                    TreeNode temp = new TreeNode(i);
                    temp.left = a;
                    temp.right = b;
                    //加入到最终结果中
                    res.add(temp);
                }
            }
        }
        return res;
    }
}
