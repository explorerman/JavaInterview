package LeetCode_array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution442 {

	/**
	 * 数组中重复的数据
	 * @param nums
	 * @return
	 */
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> result = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		int len = nums.length;
		if (len == 0)
			return result;
		for (int i = 0; i < len; i++) {
			if (!set.contains(nums[i])) {
				set.add(nums[i]);
			} else {
				result.add(nums[i]);
			}

		}
		return result;
	}

	/**
	 * 这个题目开头暗示了n的范围，所以可以加以利用，将元素转换成数组的索引并对应的将该处的元素乘以-1；

	 若数组索引对应元素的位置本身就是负数，则表示已经对应过一次；在结果列表里增加该索引的正数就行；

	 * @param nums
	 * @return
	 */
	public List<Integer> findDuplicates2(int[] nums) {
		List<Integer> rs = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			// [4,3,2,7,8,2,3,1]
			if (nums[Math.abs(nums[i]) - 1] < 0) {
				rs.add(Math.abs(nums[i]));
			} else {
				nums[Math.abs(nums[i]) - 1] *= -1;
			}
		}

		return rs;
	}

	public static void main(String[] args) {
		// [4,3,2,7,8,2,3,1]
//		int[] nums = {4,3,2,7,8,2,3,1};
		int[] nums = {3,1,3,4,2};
		List<Integer> result = new Solution442().findDuplicates2(nums);
	}

}
