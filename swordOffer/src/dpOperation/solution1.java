package dpOperation;

public class solution1 {

	/**
	 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
	 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
	 * @param n
	 * @return
	 */
	int climbStairs(int n){
		if(n <= 2) return n;
		//边界条件
		int a = 1;
		int b = 2;
		int result = 0;
		for(int i = 3; i < n; i++){
			result = a + b;
			a = b;
			b = result;
		}
		return result;
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
