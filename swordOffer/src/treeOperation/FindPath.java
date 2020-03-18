package treeOperation;

import java.util.ArrayList;

public class FindPath {

	/**
	 * ��Ŀ��
	 * ����һ�Ŷ������ĸ��ڵ��һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
	 * ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����(ע��: �ڷ���ֵ��list�У����鳤�ȴ�����鿿ǰ)
	 */
	private	ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
	private ArrayList<Integer> list = new ArrayList<>();
	
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		if(root == null) return listAll;
		list.add(root.val);
		target -= root.val;
		if(target == 0 && root.left == null && root.right == null){
			//һ�������
			listAll.add(new ArrayList<>(list));
		}
		FindPath(root.left, target);
		FindPath(root.right, target);
		//��������������ǰ�ڵ�,�Ƴ����һ��Ԫ�أ���ȱ�����һ��·����Ҫ���ˡ�ԭ�򣺵ݹ鵽Ҷ�ӽڵ������û���ҵ�·������Ҫ���˵����ڵ����Ѱ�ң���������
		list.remove(list.size() - 1);
		return listAll;
    }
	public static void main(String[] args) {

	}

}
