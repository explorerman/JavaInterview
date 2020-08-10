package LeetCode_array;

/**
 * @author 李杰
 * @version 1.0
 * @Description 下一个更大元素1
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/8/10 15:05
 * @title 标题: 下一个更大元素1
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class number496 {
    // 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
    //输出: [-1,3,-1]

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[len1];
        for (int i = 0; i < len1; i++) {
            //转换成在nums2中找比target大的第一个数
            res[i] = findFirstLargeNum(nums1[i], nums2);
        }
        return res;
    }

    private int findFirstLargeNum(int target, int[] nums2) {
        for (int i = 0; i < nums2.length; i++) {
            if(target == nums2[i]){
                for (int j = i + 1; j < nums2.length; j++) {
                    if(nums2[j] > target){
                        return nums2[j];
                    }
                }
            }
        }
        return -1;
    }
}
