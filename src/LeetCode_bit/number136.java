package LeetCode_bit;

public class number136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,1,0,1,99};
        new number136().singleNumber(nums);
    }
}
