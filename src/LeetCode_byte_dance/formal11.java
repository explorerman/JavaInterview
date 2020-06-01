package LeetCode_byte_dance;

//将一颗二叉树转化成单链表，将每个节点的左子树插入该节点和其右子树之间，左子指向Null
//lc114题
//找到左子树的最右边节点，挂在右子树上
public class formal11 {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode temp = cur.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}
