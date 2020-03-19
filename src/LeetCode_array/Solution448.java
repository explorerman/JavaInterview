package LeetCode_array;

import java.util.ArrayList;
import java.util.List;

public class Solution448 {

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
