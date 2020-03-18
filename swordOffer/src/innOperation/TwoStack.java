package innOperation;

import java.util.Stack;

public class TwoStack {

	/**
	 * 本题题目：两个栈实现一个队列
	 * 思路：队列是先进先出，栈是先进后出，可以使用两个栈来实现队列
	 */
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) { //入栈
        stack1.push(node);
    }
    
    public int pop() { //出栈
    	if(!stack2.isEmpty()){
    		return stack2.pop();
    	}
    	while(!stack1.isEmpty()){
    		stack2.push(stack1.pop());
    	}
		return stack2.pop();
    
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
