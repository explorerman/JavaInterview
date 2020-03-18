package arrayOperation;

import java.util.ArrayList;

public class GetLeastNumbers_Solution {

	/**
	 * ��С��k����
	 * ˼·��ð�������˼�룬ֻ���������ѭ��K�ξͿ����ˣ�Ҳ����˵����ȫ������ֻ�������������K���Ϳ��ԡ�
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
		// 4,5,1,6,2,7,3,8��8�����֣������� 1,2,3,4
	}

}
