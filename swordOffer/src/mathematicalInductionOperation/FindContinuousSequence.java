package mathematicalInductionOperation;

import java.util.ArrayList;

public class FindContinuousSequence {

	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		//两个起点，充当滑动窗口的边界，根据窗口内的值的和来确定窗口的位置和大小
		int pLow = 1, pHigh = 2;
		while(pHigh > pLow){
			//由于是连续的，差为1的等差数列，求和公式为：（a0+an）* (an-a0 + 1) / 2
			int cur = (pHigh + pLow) * (pHigh - pLow + 1) / 2; 
			//若滑动窗口内的值的和等于结果，则将该滑动窗口内的值添加到一维列表中，最后加到result二维列表中。
			if(cur == sum){
				ArrayList<Integer> list = new ArrayList<>();
				for(int i = pLow; i <= pHigh; i++){
					list.add(i);
				}
				result.add(list);
				pLow++;   
			}else if(cur < sum){ //如果当前窗口内的值小于sum，则高位后移一位。
				pHigh++;
			}else if(cur > sum){  //如果当前窗口的值大于sum，则低位移动一位
				pLow++;
			}
		}
		return result;
    }
	public static void main(String[] args) {
	}
}
