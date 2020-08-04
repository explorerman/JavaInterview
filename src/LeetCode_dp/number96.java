package LeetCode_dp;

import java.util.ArrayList;
import java.util.List;

//不同的二叉搜索树
public class number96 {
    public int numTrees(int n) {
        if(n == 0) return 0;
        return helper(1,n).size();
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        //此时没有数字，将 null 加入结果中
        if(start > end){
            res.add(null);
            return res;
        }
        //尝试每个数字作为根节点
        for (int i = start; i <= end; i++) {
            //得到所有可能的左子树
            List<TreeNode> left = helper(start, i - 1);
            //得到所有可能的右子树
            List<TreeNode> right = helper(i + 1, end);
            //左子树右子树两两组合
            for (TreeNode a : left){
                for (TreeNode b : right){
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
