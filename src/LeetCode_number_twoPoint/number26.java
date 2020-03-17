package LeetCode_number_twoPoint;

public class number26 {
    //nums = [0,0,1,1,1,2,2,3,3,4], 0, 1, 2, 3, 4。
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != nums[j]){
                nums[++j] = nums[i];
            }
        }
        return nums.length == 0 ? 0 : j+1;
    }

    public static void main(String[] args) {

        new number26().removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
    }
}
