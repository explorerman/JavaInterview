package leetcode_tree;

//二叉树的最大深度
public class number104 {
    //dfs的最简单应用.
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftLength = maxDepth(root.left) + 1;
        int rightLength = maxDepth(root.right) + 1;
        return Math.max(leftLength,rightLength);
    }

    //bfs的写法
    public int maxDepth2(TreeNode root){
        return 0;
    }
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        int i = maxDepth(n1);
        System.out.println(i);


    }
}
