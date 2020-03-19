package LeetCode_array;

import java.util.ArrayList;
import java.util.List;
//找到所有数组中消失的数字
public class Solution448 {

	//思路：跟442题解法一样
	//  对每个数字nums[i],如果其对应的nums[nums[i] -1]是正数，
	//  我们就赋值为其相反数，如果已经是负数了，就不变了，最后我们只要把留下的正整数对应的位置加入结果链表中即可。
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> rs = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			// [4,3,2,7,8,2,3,1]
			if (nums[Math.abs(nums[i]) - 1] > 0) {
				nums[Math.abs(nums[i]) - 1] *= -1;
			}
		}
		// [-4,-3,-2,-7,8,2,-3,-1]
		for(int i = 0; i < nums.length; i++){
			if(nums[i] > 0){
				rs.add(i+1);
			}
		}

		return rs;
	}

	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1};
		List<Integer> result = new Solution448().findDisappearedNumbers(nums);
	}

}
