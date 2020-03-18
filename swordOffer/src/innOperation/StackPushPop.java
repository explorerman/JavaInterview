package innOperation;

import java.util.Stack;

public class StackPushPop {

	/**
	 * 本题题目：栈的压入、弹出序列
	 * 题目描述：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
	 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
	 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
	 * 
	 * @param args
	 */
	public boolean IsPopOrder(int [] pushA,int [] popA) {
		if(pushA.length == 0 || popA.length == 0) return false;
		Stack<Integer> stack = new Stack<Integer>();  //辅助栈
		//用于标识弹出序列的位置
		int popIndex = 0;
		for(int i = 0; i < pushA.length; i++){
			stack.push(pushA[i]);
			while(!stack.isEmpty() && stack.peek() == popA[popIndex]){
				stack.pop();  //辅助栈弹出元素
				//弹出序列向后挪一位
				popIndex++;
			}
		}
		return stack.empty();
		
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
