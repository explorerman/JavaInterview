package arrayOperation;

public class Find {

	/**
	 * 二维数组中的查找
	 * @param array
	 * @param target
	 * @return
	 */
	//二分法,典型的二分法模板
	public boolean Find(int [][]array,int target){
		int rowLength = array.length;
		for(int i = 0; i < rowLength; i++){
			int low = 0;
			int high = array[i].length - 1;
			while(low <= high){   //注意循环条件是low <= high 
				int mid = low + (high - low)/2;
				if(target > array[i][mid]){
					low = mid + 1;
				}else if(target < array[i][mid]){
					high = mid - 1;
				}else{
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean Find2(int [][]array,int target){
		int m,n,x,y;
		m = array.length; //行数
		n = array[0].length; //列数
		x = m-1;
		y = 0;
		while(x>=0 && y<=n-1){
			if(target<array[x][y]){
				x--;
			}
			else if(target>array[x][y]){
				y++;
			}
			else{
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {

	}

}
