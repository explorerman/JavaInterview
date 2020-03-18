package bitOperation;

public class solution1 {

	/**
	 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
	 * @param
	 */
	public int NumberOf1(int n) {
		int count = 0;
		while(n != 0){
			if((n & 1) > 0){
				count++;
			}
			//这里一定要无元素右移
			n = n >>> 1;
		}
		return count;
		
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
