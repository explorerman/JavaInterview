package arrayOperation;

public class Find {

	/**
	 * ��ά�����еĲ���
	 * @param array
	 * @param target
	 * @return
	 */
	//���ַ�,���͵Ķ��ַ�ģ��
	public boolean Find(int [][]array,int target){
		int rowLength = array.length;
		for(int i = 0; i < rowLength; i++){
			int low = 0;
			int high = array[i].length - 1;
			while(low <= high){   //ע��ѭ��������low <= high 
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
		m = array.length; //����
		n = array[0].length; //����
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
