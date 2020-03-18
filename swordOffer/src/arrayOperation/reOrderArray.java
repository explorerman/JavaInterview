package arrayOperation;

import java.util.ArrayList;
import java.util.List;

public class reOrderArray {

	/**
	 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣�
	 * ���е�ż��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
	 * 
	 * ˼·1���½�����������ż�����飬�Ƚ�������ż���ֿ�������ٺϲ����ÿռ任ʱ�䡣������reOrderArray1
	 * ˼·2����ÿһ��Ԫ�ؽ�������ð������Ĳ��������������ʼ���ж�ǰ���Ƿ�����ż��磬���ǣ��򽻻���������reOrderArray2
	 * @param array
	 */
	public void reOrderArray1(int [] array) {
        int length = array.length;
        if(length <= 1) return;
        List<Integer> odds = new ArrayList<>();  //����
        List<Integer> enens = new ArrayList<>();  //ż��
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
