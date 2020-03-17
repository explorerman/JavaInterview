package leetcode_tree;

public class number108 {

    //平衡树：左右子树高度差不超过1，搜索树：根节点大于左节点，小于右节点
    //[-10,-3,0,5,9]   [0,-3,9,-10,null,5]
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        TreeNode res = sort(nums, 0, nums.length -1);
        return res;
    }
    public TreeNode sort(int[] nums, int start, int end){
        if(start > end) return null;
        int middle = start + (end - start) / 2 ;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = sort(nums, start, middle - 1);
        root.right = sort(nums, middle + 1, end);
        return root;
    }
    private static String abc;
    public static void main(String[] args) {
        System.out.println(abc.equals("2"));
    }
}
