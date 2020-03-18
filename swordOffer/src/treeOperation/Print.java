package treeOperation;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Print {

	/**
	 * ˼·���ڲ�������Ļ����ϣ����Ӹ�������������������������������ʹ��LinkedList˫������
	 * @param pRoot
	 * @return
	 */
	public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> layers = new ArrayList<>();
		if(pRoot == null) return layers;
		Deque<TreeNode> queue = new LinkedList<>();
		queue.offer(pRoot);
		int depth = 0;
		while(!queue.isEmpty()){
			depth++;
			ArrayList<Integer> layer = new ArrayList<>();
			int cur = 0, size = queue.size();
			if((depth & 1) == 0){  //ż�����������
				Iterator<TreeNode> iterator = queue.descendingIterator();
				while(iterator.hasNext()){
					layer.add(iterator.next().val);
				}
			}
			else{   //�������������
				Iterator<TreeNode> iterator = queue.iterator();
				while(iterator.hasNext()){
					layer.add(iterator.next().val);
				}
			}
			while(cur < size){
				TreeNode node = queue.poll();
				if(node.left != null) queue.offer(node.left);
				if(node.right != null) queue.offer(node.right);
				cur++;
			}
			layers.add(layer);
		}
		return layers;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
