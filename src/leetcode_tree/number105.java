package leetcode_tree;

public class number105 {
    // 前序遍历 preorder = [3,9,20,15,7] 根左右
    //中序遍历 inorder = [9,3,15,20,7]  左根右
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) return null;
        TreeNode root = reBuildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length -1);
        return root;
    }
    public TreeNode reBuildTree(int[] preorder, int preStart,int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] == preorder[preStart]){
                root.left = reBuildTree(preorder,preStart+1,i-inStart + preStart,inorder,inStart,i-1);
                root.right = reBuildTree(preorder,preStart+i-inStart+1,preEnd,inorder,i+1,inEnd);
                break;
            }
        }
        return root;
    }
}
