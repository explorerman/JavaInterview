package LeetCode_array;

import java.util.Arrays;
//颜色分类
public class number75 {
//    输入: [2,0,2,1,1,0]
//    输出: [0,0,1,1,2,2]

    //思路：遍历一个数组，分别记录0,1,2的个数
    //然后更新原数组，按个数分别赋值0,1,2
    public void sortColors(int[] nums) {
        int[] colors = new int[3];
        int length = nums.length;
        for (int num: nums) {
            colors[num]++;
        }
        for (int i = 0, cur = 0; i < 3; i++) {  //红绿蓝
            for (int j = 0; j < colors[i]; j++) {
                nums[cur++] = i;
            }
        }
    }

    //因为本题的特殊性，所以如果想迅速ac，可以直接使用API解决。
    public void sortColors2(int[] nums) {
        Arrays.sort(nums);
    }

    //双指针解法：定义red指针指向开头位置,blue指针指向末尾位置
    //从开开始遍历原数组，如果遇到0，则交换该值和red指针指向的值，并将red指针后移一位，若遇到2，则交换
    //该值和blue指针指向的值，并将blue指针前移一位，若遇到1，则继续遍历
    public void sortColors3(int[] nums) {
        int length = nums.length; // [0,1,2]
        int red = 0, blue = length - 1;
        for (int i = 0; i <= blue; i++) {
            if(nums[i] == 0){
                swap(nums,i,red++);  //从左边开始的，所以不需要重新审核交换后的值是什么情况
            }else if(nums[i] == 2){
                swap(nums, i--, blue--);  //因为交换后，并不知道交换后的值是什么情况，所以需要回退，重新判断
            }
        }
    }

    private void swap(int[] nums, int first, int second) {
        int temp;
        temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

}
