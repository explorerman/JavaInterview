package LeetCode_BinarySearch;

import java.util.Arrays;

//寻找两个有序数组的中位数
public class number4 {
    //使用m+n的时间复杂度，来新建排序数组，后续使用二分做，log(m+n)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0;
        int len1 = nums1.length, len2 = nums2.length;
        if(len1 == 0 && len2 == 0) return res;
        int[] resArr = new int[len1+len2];
        for (int i = 0; i < len1; i++) {
            resArr[i] = nums1[i];
        }
        for (int i = 0; i < len2; i++) {
            resArr[len1 + i] = nums2[i];
        }
        Arrays.sort(resArr);
        int temp = (len1+len2) / 2;
        if((len1+len2) % 2 == 0){
            res = ((double) resArr[temp - 1] + (double) resArr[temp]) / 2;
        }else{
            res = resArr[temp + 1];
        }
        return res;
    }

    public static void main(String[] args) {
        double i = 5.0;
        System.out.println(i / 2);
    }
}
