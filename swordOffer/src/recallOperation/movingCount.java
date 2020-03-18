package recallOperation;

public class movingCount {

	public int movingCount(int threshold, int rows, int cols) {
		int[][] flag = new int[rows][cols];
		return bfs(0, 0, rows, cols, flag, threshold);
	}
	private int bfs(int i, int j, int rows, int cols, int[][] flag, int threshold){
		if(i < 0 || i >= rows || j < 0 || j >= cols ||flag[i][j] == 1 || numSum(i) + numSum(j) > threshold) return 0;
			flag[i][j] = 1;
			return    bfs(i - 1, j, rows, cols, flag, threshold)
					+ bfs(i + 1, j, rows, cols, flag, threshold)
					+ bfs(i, j - 1, rows, cols, flag, threshold)
					+ bfs(i, j + 1, rows, cols, flag, threshold)
					+ 1;
		
	}
	private int numSum(int i){
		int sum = 0;
//		return sum = (i % 10) + (i / 10);
		do{
			sum += i % 10;
		}while((i = i / 10) > 0);
		return sum;
		
		
	}
	public static void main(String[] args) {
		System.out.println(new movingCount().numSum(-35));

	}

}
