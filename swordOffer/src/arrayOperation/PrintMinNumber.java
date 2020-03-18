package arrayOperation;

import java.util.Arrays;
import java.util.Comparator;

public class PrintMinNumber {

	/**
	 * ����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
	 * ������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
	 * @param numbers
	 * @return
	 */
	public String PrintMinNumber(int[] numbers) {
		if(numbers == null || numbers.length == 0) return "";
		int len = numbers.length;
		StringBuilder s = new StringBuilder();
		String[] str = new String[len];
		for(int i = 0; i < len; i++){
			str[i] = String.valueOf(numbers[i]);
		}
		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				 	String c1 = str1 + str2;
	                String c2 = str2 + str1;
	                return c1.compareTo(c2);
			}
		});
		for(String temp : str){
			s.append(temp);
		}
		return s.toString();
	}

	public static void main(String[] args) {

	}

}
