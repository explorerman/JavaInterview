package treeOperation;

public class HasSubtree {
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		boolean result = false;
		//当tree1和tree2都不为零的时候，才进行比较
		if(root1 != null && root2 != null){
			//如果找到了对应tree2的根节点
			if(root1.val == root2.val){  
				//以这个根节点为起点判断是否包含tree2
				result = doesTree1HaveTree2(root1, root2);
			}
			//如果找不到，再去tree1的左节点找
			if(!result){
				result = HasSubtree(root1.left, root2);
			}
			//如果找不到，去tree1的右节点找
			if(!result){
				result = HasSubtree(root1.right, root2);
			}
		}
		return result;
    }
	public boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2){
		//如果tree2已经遍历完了并且能对应上，则返回true
		if(node2 == null) return true;
		//如果tree2还没有完，tree1自己先完了，则返回false
		if(node1 == null) return false;
		//如果发现有个结点没对应上，则返回false
 		if(node1.val != node2.val) return false;
 		//如果根结点对应的上，那就分别去子结点里进行匹配。
 		return (doesTree1HaveTree2(node1.left, node2.left) && doesTree1HaveTree2(node1.right, node2.right));
	}
	public static void main(String[] args) {
	}
}
