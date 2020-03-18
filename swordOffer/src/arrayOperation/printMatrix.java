package arrayOperation;

import java.util.ArrayList;

public class printMatrix {
	/**
	 * 顺序打印矩阵
	 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

		思路：每次while循环都是四个方向（右下左上）的遍历，定义好初值，按照方向遍历。
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
			//解决矩阵只有一行出现回文的情况
			if(top <= bottom){
				for(int i = right; i >= left; i--){
					list.add(matrix[bottom][i]);
				}
				bottom--;
			}
			//解决矩阵只有一列出现的回文
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
