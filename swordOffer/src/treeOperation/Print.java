package treeOperation;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Print {

	/**
	 * 思路：在层序遍历的基础上，增加根据行数进行正向反向迭代（正向反向迭代使用LinkedList双向链表）
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
			if((depth & 1) == 0){  //偶数层则反序输出
				Iterator<TreeNode> iterator = queue.descendingIterator();
				while(iterator.hasNext()){
					layer.add(iterator.next().val);
				}
			}
			else{   //奇数层正序输出
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
