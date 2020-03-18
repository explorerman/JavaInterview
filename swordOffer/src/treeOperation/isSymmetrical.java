package treeOperation;

public class isSymmetrical {

	/**
	 * ��Ŀ��
	 * ��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
	 * ˼·���ݹ鷽��
	 * @param pRoot
	 * @return
	 */
	boolean isSymmetrical(TreeNode pRoot)
    {
		if(pRoot == null) return true;
		return isSame(pRoot.left, pRoot.right);
        
    }
	private boolean isSame(TreeNode left, TreeNode right){
		if(left == null) return right == null;
		if(right == null) return false;
		if(left.val == right.val){
			return isSame(left.left, right.right) && isSame(left.right, right.left);
		}else{
		return false;
		}
	}
	public static void main(String[] args) {
	}
}
