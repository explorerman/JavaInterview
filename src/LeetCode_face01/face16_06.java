package LeetCode_face01;

import java.util.Arrays;

/**
 * @author 李杰
 * @version 1.0
 * @Description 最小差
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/6/19 15:33
 * @title 标题: 最小差
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
//1,2,3,11,15
//8,19,23,127,235
//最小差
public class face16_06 {
    //暴力破解超时
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int lenA = a.length;
        int lenB = b.length;
        if(lenA <= 0 || lenB <= 0) return -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < lenA; i++) {
            for (int j = 0; j < lenB; j++) {
                long diff = a[i] - b[j];
                min = (int) Math.min(min, Math.abs(diff));
            }
        }
        return min;
    }
    //双指针
    public int smallestDifference2(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int lenA = a.length;
        int lenB = b.length;
        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;
        while (i < lenA && j < lenB){
            long diff = a[i] - b[j];
            min = (int)Math.min(min, Math.abs(diff));
            if(diff > 0){
                j++;
            }else {
                i++;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        new face16_06().smallestDifference(new int[]{-2147483648,1}, new int[]{2147483647,0});
    }
}
