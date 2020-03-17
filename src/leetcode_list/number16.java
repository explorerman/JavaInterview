package leetcode_list;

public class number16 {
    //其实就是通过绝对值来判断距离，然后记录下来sum，最后return
    public static int threeSumClosest(int[] nums, int target) {
        int sum = nums[0]+nums[1]+nums[2];
        int distance = Math.abs(sum - target);
        int result = sum;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){
                    sum = nums[i] + nums[j] + nums[k];
                    int newDistance = Math.abs(sum - target);
                    if(distance > newDistance){
                        distance = newDistance;
                        result = sum;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }
}
