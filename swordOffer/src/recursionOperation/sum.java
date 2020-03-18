package recursionOperation;

public class sum {

	//利用递归求1+2...n的和
	/**
	 * 思路：递归与实际生活中思路的方式相反。
	 * 实际生活中加法是从1+n，在递归中，是从n+1
	 * 本题中递归的出口是当n加到1,0的时候。
	 * @param n
	 * @return
	 */
	public static int Sum_Solution(int n){
		int sum = n;
		if(n <= 0) return 0;
		if(n == 1) return 1;
		return sum + Sum_Solution(n-1);
	}
	public static void main(String[] args) {
		int n = Sum_Solution(5);
		System.out.println(n);

	}

}
