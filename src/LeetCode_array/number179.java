package LeetCode_array;

import java.util.Arrays;
import java.util.Comparator;

public class number179 {
    //8，91，6，35，
    //3,30,34,5,9
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        int len = nums.length;
        //因为要使用Arrays.sort();该方法需要是T数组，而给的基本类型数组，所以需要包装成Integer数组
        Integer[] newNums = new Integer[len];
        for (int i = 0; i < len; i++) {
            newNums[i] = nums[i];
        }
        Arrays.sort(newNums, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                //将数组中的两个数，拼接成字符串比较，比如：3，30
                //str1: 3+30 = 330，str2 = 30+3 = 303
                //330 > 303,即str1 > str2,所以按从大到小排序，3要排在30的前面
                String str1 = o1.toString() + o2.toString();
                String str2 = o2.toString() + o1.toString();
                //compareTo方法：
                //如果参数str2 > str1时，返回>0, 如果参数str2 < str1时，返回 < 0
                //如果相等则返回0
                //总之一点，2在1之前，说明是降序，1在2之前是升序
                //谁在前面谁大，str2.compareTo(str1),代表着str2大，数组按从大到小排
                return str2.compareTo(str1);
            }
        });
        for (int i = 0; i < len; i++) {
            sb.append(newNums[i]);
        }
        //返回数组为空的情况
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }

}
