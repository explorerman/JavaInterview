package arrayOperation;

public class GetNumberOfK {

	/**
	 * ?????????????????????§Ô?????????
	 * @param array
	 * @param k
	 * @return
	 */
	public static int GetNumberOfK(int[] array, int k) {
		if(array.length == 0) return 0;
		int count = 0;
		for(int i = 0; i < array.length; i++){
			if(k == array[i]){
				count++;
			}else{
				continue;
			}
		}
		return count;
	}
	
	public int GetNumberOfK2(int[] array, int k){
		int length = array.length;
		if(length == 0) return 0;
		int firstK = getFirstK(array, k, 0, length - 1);
		int lastK = getLastK(array, k, 0, length - 1);
		if(firstK != -1 && lastK != -1)
			return lastK - firstK + 1;
		return 0;
	}
	
	private int getLastK(int[] array, int k, int start, int end) {
		int length = array.length;
		int mid = start + (end - start)/2;
		while(start < end){
			if(array[mid] > k){
				end = mid - 1;
			}else if(array[mid] < k){
				start = mid + 1;
			}else if(mid + 1 < length && array[mid + 1] == k){
				start = mid + 1;
			}else{
				return mid;
			}
			mid = start + (end - start)/2;
		}
		return -1;
	}

	private int getFirstK(int[] array, int k, int start, int end) {
		if(start > end) return -1;
		int mid = start + (end - start)/2;
//		int mid = (start + end) >> 1;
		if(array[mid] > k){
			return getFirstK(array, k, start, mid - 1);
		}else if(array[mid] < k){
			return getFirstK(array, k, mid + 1, end);
		}else if(mid - 1 >= 0 && array[mid -1 ] == k){
			return getFirstK(array, k, start, mid - 1);
		}else{
			return mid;
		}
	}

	public static void main(String[] args) {
		// [1,2,3,3,3,3,4,5],  3
		int[] array = new int[]{1,2,3,3,3,3,4,5};
		int number = new GetNumberOfK().GetNumberOfK2(array, 3);
		System.out.println(number);
	}

}
