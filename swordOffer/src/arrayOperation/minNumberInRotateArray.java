package arrayOperation;

public class minNumberInRotateArray {

	public int minNumberInRotateArray(int[] array) {
		if(array.length == 0) return 0;
		if(array.length == 1) return array[0];
		for(int i = 0; i < array.length; i++){
			if(array[i] > array[i + 1]){
				return array[i + 1];
			}
		}
		return array[0];
	}

	
	
	public static void main(String[] args) {

	}

}
