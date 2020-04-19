package LeetCode_review_2;

//双指针
//代码题：数组a,先单调递增再单调递减，输出数组中不同元素个数。要求：O(1)空间复杂度，不能改变原数组
public class practice_1 {
    public int practice_1(int[] nums){
        int left = 0, right = nums.length - 1;
        int count = 0;
        while (left <= right){
            if(nums[left] > nums[right]){
                right--;
                count++;
            }else if(nums[left] < nums[right]){
                left++;
                count++;
            }else{
                left++;
                right--;
            }
        }
        System.out.printf("count = "+ count);
        return count+1;
    }

    public static void main(String[] args) {
        new practice_1().practice_1(new int[]{1,3,5,6,8,9,5,4,2,1});
    }
}
