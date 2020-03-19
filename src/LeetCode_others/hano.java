package LeetCode_others;

//汉诺塔
public class hano {

	/**
	 * 1. 把n-1号盘子移动到缓冲区
	 * 2. 把1号从起点移到终点
	 * 3. 把缓冲区的n-1号盘子也移到终点
	 * @param a 起始塔
	 * @param b 辅助塔
	 * @param c 目标塔
	 * @param n 圆盘数量
	 */
	public static void hano(String a, String b, String c,int n){
		if(n > 0){ 			//出口
			hano(a, c, b, n-1);
			move(a, c);
			hano(b, a, c, n-1);
		}
	}

	public static void move(String a, String b){
		System.out.println(a + "->" + b);
	}

	public static void main(String[] args) {
		hano("a", "b", "c", 3);
	}
}
