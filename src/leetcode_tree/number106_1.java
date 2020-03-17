package leetcode_tree;

public class number106_1 {
    //中序遍历 inorder = [9,3,15,20,7] 左中右
    //后序遍历 postorder = [9,15,7,20,3] 左右中
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0){
            return null;
        }
        TreeNode root = reBuild(inorder, 0, inorder.length -1 ,postorder, 0, postorder.length -1);
        return root;
    }
    public TreeNode reBuild(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        if(inStart > inEnd || postStart > postEnd){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] == postorder[postEnd]){
                root.left = reBuild(inorder,inStart, i - 1, postorder, postStart, postStart+ i - inStart-1);
                root.right = reBuild(inorder,i+1,inEnd,postorder,postStart+i - inStart ,postStart+i-inStart + inEnd - i -1);
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
    }
}
