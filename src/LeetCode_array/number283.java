package LeetCode_array;

//移动零，要求必须在原数组上操作，不能拷贝额外的数组。
//尽量减少操作次数。
public class number283 {
    //输入: [0,1,0,3,12]
    //输出: [1,3,12,0,0]
    //解决思路就是:使用双指针，一个指针用来遍历数组，一个用来指向非零元素
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        if(length == 0) return;
        int number = 0;  //用来指向非零元素
        for (int i = 0; i <length; i++) {
            if(nums[i] != 0){
                nums[number++] = nums[i];
            }
        }
        for (int i = number; i < length; i++) {
            nums[number++] = 0;
        }
    }

}
