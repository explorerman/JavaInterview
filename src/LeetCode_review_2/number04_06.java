package LeetCode_review_2;


import java.util.ArrayList;
import java.util.List;

/**
 * @author 李杰
 * @version 1.0
 * @Description 后继者
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/4/30 9:27
 * @title 标题: 后继者
 * @copyright Copyright (c) 2020 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class number04_06 {
    //利用二叉树的性质 （3ms）
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        if (p.val >= root.val) {
            TreeNode right = inorderSuccessor(root.right, p);
            return right;
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return left != null ? left : root;
        }
    }

    //右根左  (4ms)
    TreeNode pre = null;
    TreeNode res = null;
    public TreeNode inorderSuccessor3(TreeNode root, TreeNode p) {
        inOrder2(root,p);
        return res;
    }
    private void inOrder2(TreeNode root, TreeNode p) {
        if (root == null) return;
        if (root.right != null) inOrder2(root.right, p);
        if(p.val == root.val){
            res = pre;
            return;
        }
        pre = root;
        if (root.left != null) inOrder2(root.left, p);
    }

    //左根右，使用list（5ms）
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        List<TreeNode> result = new ArrayList<>();
        inOrder(root, result);
        for (int i = 0; i < result.size(); i++) {
            if (p == result.get(i) && i != result.size() - 1) return result.get(i + 1);
        }
        return null;
    }

    private void inOrder(TreeNode root, List<TreeNode> result) {
        if (root == null) return;
        if (root.left != null) inOrder(root.left, result);
        result.add(root);
        if (root.right != null) inOrder(root.right, result);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        inorderSuccessor(n1, n3);

    }
}
