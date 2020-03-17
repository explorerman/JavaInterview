package LeetCode_array;

//删除排序数组中的重复项2
public class number80 {
    //nums = [0,0,1,1,1,1,2,3,3],  0, 0, 1, 1, 2, 3, 3
    //解题思路：还是使用双指针，在双指针的基础上增加了计数器（计数器初始化为1，可以增加到2，也可以减少到2），target依旧是重新访问并赋值的数组的指针
    //一个指针用于迭代遍历，一个指针用于记录数组中的结果值
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if(length == 0) return 0;
        int target = 0;
        int count = 1;
        for (int i = 1; i < length; i++) {
            if(nums[i] == nums[target] && count == 2){
                continue;
            }else{
                if(nums[i] == nums[target]){  //前后元素若相等，则count++
                    count++;
                }else {
                    count = 1;      //前后元素若不相等，则说明是新元素，重新赋值为1
                }
                nums[++target] = nums[i];
            }
        }
        return target+1;
    }

    public int removeDuplicates2(int[] nums) {
        int length = nums.length;
        if(length == 0) return 0;
        int target = 0;
        int count = 1;
        for (int i = 1; i < length; i++) {
            if(nums[i] == nums[target] && count == 0){
                continue;
            }else{
                if(nums[i] == nums[target]){  //前后元素若相等，则count--
                    count--;
                }else {
                    count = 1;      //前后元素若不相等，则说明是新元素，重新赋值为1
                }
                nums[++target] = nums[i];
            }
        }
        return target+1;
    }

    public static void main(String[] args) {
        new number80().removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3});
    }
}
