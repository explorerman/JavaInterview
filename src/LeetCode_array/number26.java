package LeetCode_array;

//删除元素中的重复项
public class number26 {
    //nums = [0,0,1,1,1,2,2,3,3,4],
    //解题思路：双指针，一个元素用于迭代遍历，另一个元素指向数组中不重复的元素
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if(length == 0) return 0;
        int unique = 0;
        for (int i = 1; i < length; i++) {
            if(nums[i] != nums[unique]){
                nums[++unique] = nums[i];   //先自增，在赋值，是因为本身已经是唯一元素，所以需要需要先自增
            }else{
                continue;
            }
        }
        return unique + 1;
    }
}
