package arrayOperation;

import java.util.ArrayList;

public class GetLeastNumbers_Solution {

	/**
	 * 最小的k个数
	 * 思路：冒泡排序的思想，只不过最外层循环K次就可以了，也就是说不用全部排序，只挑出符合提议的K个就可以。
	 * 
	 * @param input
	 * @param k
	 * @return
	 */
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> list = new ArrayList<>();
		int length = input.length;
		if (k > length)
			return list;
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < input.length - i - 1; j++) {
				if (input[j] < input[j + 1]) {
					int temp = input[j];
					input[j] = input[j + 1];
					input[j + 1] = temp;
				}
			}
			list.add(input[input.length - i - 1]);
		}
		return list;
	}

	public static void main(String[] args) {
		// 4,5,1,6,2,7,3,8这8个数字，最后输出 1,2,3,4
	}

}
