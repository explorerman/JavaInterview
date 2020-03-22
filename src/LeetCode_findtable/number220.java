package LeetCode_findtable;

//存在重复元素元素3
public class number220 {
    //暴力破解  时间复杂度太高，仅仅击败全国百分之5的人
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int length = nums.length;
        if(nums.length < 0) return false;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; ((j - i) <= k) && j < length; j++) {
                long res = Math.abs((long)nums[j] - (long)nums[i]);  //防止int越界，这时候可以转化为精度更高的long
                if(res <= t){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new number220().containsNearbyAlmostDuplicate(new int[]{-1,2147483647},1,2147483647));
    }
}
