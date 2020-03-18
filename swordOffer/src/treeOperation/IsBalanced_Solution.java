package treeOperation;

public class IsBalanced_Solution {

	/**
	 * ��Ŀ��
	 * ����һ�ö��������жϸö������Ƿ���ƽ���������
	 * 
	 * ˼·1��
	 * ����ÿһ���ڵ㣬������һ����ȡ����ȵĵݹ麯�������ݸý������������߶Ȳ��ж��Ƿ�ƽ�⣬Ȼ��ݹ�Ķ��������������жϡ�
	 * 
	 * ˼·2��
	 * ˼·1���к����Ե����⣬���ж��ϲ����ʱ�򣬻����ظ������²��㣬�����˲���Ҫ�Ŀ����������Ϊ�������ϱ��������
	 * ������ƽ����������򷵻������ĸ߶ȣ����������������ƽ�����������ֱ��ֹͣ��������������ֻ��ÿ��������һ�Ρ�
	 * @param root
	 * @return
	 */
	public boolean IsBalanced_Solution(TreeNode root) {
		if(root == null) return true;
		return Math.abs(maxDept(root.left) - maxDept(root.right)) <= 1 && 
				IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
	public int maxDept(TreeNode root){
		if(root == null) return 0;
		return 1 + Math.max(maxDept(root.left), maxDept(root.right));
				
	}
	
	public boolean IsBalanced_Solution2(TreeNode root) {
		return getDept(root) != -1;
    }
	public int getDept(TreeNode root){
		if(root == null) return 0;
		int left = getDept(root.left);
		if(left == -1) return -1;
		int right = getDept(root.right);
		if(right == -1) return -1;
		return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
				
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
