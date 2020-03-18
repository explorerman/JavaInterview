package arrayOperation;

import java.util.ArrayList;

public class printMatrix {
	/**
	 * ˳���ӡ����
	 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣����磬�����������4 X 4���� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

		˼·��ÿ��whileѭ�������ĸ������������ϣ��ı���������ó�ֵ�����շ��������
	 * @param matrix
	 * @return
	 */
	public static ArrayList<Integer> printMatrix(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		ArrayList<Integer> list = new ArrayList<>();
		int left = 0, right = col - 1, top = 0, bottom = row - 1;
		while(left <= right && top <= bottom){
			for(int i = left; i <= right; i++){
				list.add(matrix[top][i]);			
				}
			top++;
			for(int i = top; i <= bottom; i++){
				list.add(matrix[i][right]);
			}
			right--;
			//�������ֻ��һ�г��ֻ��ĵ����
			if(top <= bottom){
				for(int i = right; i >= left; i--){
					list.add(matrix[bottom][i]);
				}
				bottom--;
			}
			//�������ֻ��һ�г��ֵĻ���
			if(left <= right){
				for(int i = bottom; i >= top; i--){
					list.add(matrix[i][left]);
				}
				left++;
			}
		}
		return list;
	}

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		printMatrix(matrix).forEach(System.out::println);
	}

}
