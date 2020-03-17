package LeetCode_number_twoPoint;

import java.util.Arrays;

public class number88 {
    //输入:
    //nums1 = [1,2,3,0,0,0], m = 3
    //nums2 = [2,5,6],       n = 3
    //
    //输出: [1,2,2,3,5,6]
    //方法1:
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums2.length; i++) {
            nums1[m++] = nums2[0];
        }
        Arrays.sort(nums1);
    }
    //方法2：双指针，新建数组，将nums1和nums2元素比较后放入结果数组，最后将结果数组放入nums1
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m+n];
        int s1 = 0;
        int s2 = 0;
        int ress = 0;
        while (s1 < m && s2 < n){
            if(nums1[s1] < nums2[s2]){
                res[ress] = nums1[s1];
                s1++;
                ress++;
            }else{
                res[ress] = nums2[s2];
                s2++;
                ress++;
            }
        }
        if(s1 < m){
            for (int i = s1; i < m; i++) {
                res[i] = nums1[i];
            }
        }
        if(s2 < n){
            for (int i = s2; i < n; i++) {
                res[ress++] = nums2[i];
            }
        }
        nums1= res.clone();
        /*for (int i = 0; i < res.length; i++) {
            nums1[i] = res[i];
        }*/
    }

    public static void main(String[] args) {
        new number88().merge2(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
    }
}
