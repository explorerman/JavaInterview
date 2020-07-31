package LeetCode_dp;

import java.util.ArrayList;
import java.util.List;

//不同的二叉搜索树2
public class number95 {
    //这种建树问题一般来说都是用递归来解，这道题也不例外，划分左右子树，递归构造。这个其实是用到了大名鼎鼎的分治法 Divide and Conquer
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<TreeNode>();
        return helper(1,n);
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

    public static void main(String[] args) {
        new number95().generateTrees(3);
    }
}
