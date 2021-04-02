package leetcode_backtracking;

public class number238 {
    //输入: [1,2,3,4]
    //输出: [24,12,8,6]
    public int[] productExceptSelf(int[] nums) {
        if(nums.length <= 1) return null;
        int[] res = new int[nums.length];
        int temp = 1;
        for (int n : nums) {
            if(n != 0){
                temp *= n;
            }else{
                continue;
            }
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                count++;
            }
            if(count >= 2){
                return new int[nums.length];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                res[i] = temp / nums[i];
            }
            if(nums[i] == 0){
                for (int j = 0; j < nums.length; j++) {
                    if(j == i){
                        res[j] = temp;
                    }else{
                        res[j] = 0;
                    }
                }
                break;
            }
        }
        return res;
    }
    //方法2
    //某一个数字等于：它之前数字的乘积*之后数字的乘积
    //定义两个数组用来记录之前数字和之后的数字的乘积
    //分别从数组的两个方向开始遍历，依次与原数组相乘，即可得到之前数数字和之后数字乘积
    //然后两数组在相乘，即为最后结果。
    //基本思路是：后一个数字是前面数字的乘积。
    public int[] productExceptSelf2(int[] nums){  //1,2,3,4
        int length = nums.length;
        int[] res = new int[length];
        int[] left = new int[length];   //左边数字的乘积
        int[] right = new int[length];  //右边数字的乘积
        left[0] = 1;
        right[length-1] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = length - 2; i >= 0 ; --i) {
            right[i] = right[i+1] * nums[i+1];
        }
        for (int i = 0; i < length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;

    }


    public static void main(String[] args) {
        new number238().productExceptSelf2(new int[]{1,2,3,4});

        //测试方法，注重找在什么地方打日志
        int[] nums = new int[]{1,2,3,4};
        int[] res = new int[]{1,1,1,1};
        //left：从左边累乘， right：从右边累乘
        int left = 1, right = 1;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            System.out.println("i = " + i);
            res[i] *= left;
            System.out.print("res-"  + i  +  " = " + res[i] + ", ");
            left *= nums[i];
            System.out.print("left = " + left + ", ");
            res[len - 1 - i] *= right;
            System.out.print("res-" + (len - 1 - i) + " = " + res[len - 1 - i] + ", ");
            right *= nums[len - 1 - i];
            System.out.print("right = " + right  + "\n");
        }
    }
}
