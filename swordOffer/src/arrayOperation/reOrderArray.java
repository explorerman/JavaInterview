package arrayOperation;

import java.util.ArrayList;
import java.util.List;

public class reOrderArray {

	/**
	 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
	 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
	 * 
	 * 思路1：新建两个奇数、偶数数组，先将奇数、偶数分开，最后再合并，用空间换时间。方法：reOrderArray1
	 * 思路2：对每一个元素进行类似冒泡排序的操作，从数组最后开始，判断前后是否是奇偶相界，若是，则交换。方法：reOrderArray2
	 * @param array
	 */
	public void reOrderArray1(int [] array) {
        int length = array.length;
        if(length <= 1) return;
        List<Integer> odds = new ArrayList<>();  //奇数
        List<Integer> enens = new ArrayList<>();  //偶数
        for(int i = 0; i < array.length; i++){
        	if(array[i] % 2 ==0) enens.add(array[i]);
        	else{
        		odds.add(array[i]);
        	}
        }
        for(int i = 0; i < odds.size(); i++){
        	array[i] = odds.get(i);
        }
        for(int i = 0; i < enens.size(); i++){
        	array[i + odds.size()] = enens.get(i);
        }
    }
	
	public void reOrderArray2(int[] array){
		int length = array.length;
		if(length < 1) return;
		for(int i = 0; i < array.length; i++){
			for(int j = array.length - 1; j > i; j--){
				if(array[j] % 2 != 0 && array[j-1] % 2 == 0)
				swap(array, j, j-1);
			}
		}
	}
	public void swap(int[] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
