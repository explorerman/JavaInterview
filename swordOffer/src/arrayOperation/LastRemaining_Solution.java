package arrayOperation;

public class LastRemaining_Solution {

	/**
	 * 约瑟夫环 的问题。
	 * @param n
	 * @param m
	 * @return
	 */
	public int LastRemaining_Solution(int n, int m) {
		if(n == 0 || m == 0) return -1;
		int s = 0;
		for(int i = 1; i <= n; i++)
			s = (s + m) % i;
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
