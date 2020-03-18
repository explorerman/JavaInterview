package arrayOperation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MoreThanHalfNum_Solution {

	/**
	 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
	 * ��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}����������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2��
	 * ��������������0��

	˼·:��������ֵ����hashmap�У���Ϊ�����е�ֵ��valueΪ���ֵĴ�����������hashmap
	������ʹ�õ���������hashMap
	 * @param array
	 * @return
	 */
	public int MoreThanHalfNum_Solution(int [] array) {
        int length = array.length;
        if(length == 0) return 0;
        if(length == 1) return array[0];
        int size = length / 2;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < array.length; i++){
        	if(map.containsKey(array[i])){
        		int count = map.get(array[i]);
        		map.put(array[i], ++count);
        	}else{
        	map.put(array[i], 1);
        	}
        }
    	Iterator iter = map.entrySet().iterator();
	        while(iter.hasNext()){
	            Map.Entry entry = (Map.Entry)iter.next();
	            Integer key =(Integer)entry.getKey();
	            Integer val = (Integer)entry.getValue();
	            if(val>array.length/2){
	                return key;
	            }
	        }
        return 0;
    }
	public int MoreThanHalfNum_Solution2(int [] array){
		 int length = array.length;
	        if(length == 0) return 0;
	        if(length == 1) return array[0];
	        int size = length / 2;
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for(int i = 0; i < array.length; i++){
	        	if(map.containsKey(array[i])){
	        		int count = map.get(array[i]);
	        		map.put(array[i], ++count);
	        		if(map.get(array[i]) > size)
	        			return array[i];
	        	}else{
	        	map.put(array[i], 1);
	        	}
	        }
	        return 0;
	}
	public static void main(String[] args) {
		// {1,2,3,2,2,2,5,4,2}

	}

}
