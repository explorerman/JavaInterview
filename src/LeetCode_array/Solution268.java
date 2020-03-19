package LeetCode_array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution268 {

	/**
	 * 缺失数字
	 * @param nums
	 * @return
	 */

	//方法1：等差数列求和 - 数组中数字的和 == 缺失的数字
	//等差数列的求和公式：
	/**
	 * 通项公式：
	 An=A1+(n-1)d
	 An=Am+(n-m)d
	 d是公差
	 等差数列的前n项和：
	 Sn=[n(A1+An)]/2
	 Sn=nA1+[n(n-1)d]/2
	 等差数列求和公式:等差数列的和=(首数+尾数)*项数/2;
	 项数的公式:等差数列的项数=[(尾数-首数)/公差]+1.
	 * @param nums
	 * @return
	 */
	public int missingNumber(int[] nums) {
		int n = nums.length;
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		return (int) (0.5 * n * (1 + n) - sum);
	}
	//异或的方法1
	public int missingNumber2(int[] nums) {
		int res = 0;
		for(int i = 0; i < nums.length; i++){
			res = res ^ nums[i] ^ (i + 1);
		}
		return res;
	}

	//异或的方法2:

	public int missingNumber5(int[] nums) {
		int res = nums.length;
		for(int i = 0; i < nums.length; i++){
			res = res ^ nums[i] ^ i;
		}
		return res;
	}

	//排序的方法
	public int missingNumber3(int[] nums){
		Arrays.sort(nums);
		int i = 0;
		for(; i < nums.length; i++){
			if(nums[i] != i) return i;
		}
		return i;
	}

	//hashset去重
	public int missingNumber4(int[] nums) {
		Set<Integer> numSet = new HashSet<Integer>();
		for (int num : nums) numSet.add(num);

		int expectedNumCount = nums.length + 1;
		for (int number = 0; number < expectedNumCount; number++) {
			if (!numSet.contains(number)) {
				return number;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = {9,6,4,2,3,5,7,0,1};
		int result = new Solution268().missingNumber5(nums);
		System.out.println(result);
	}

}
