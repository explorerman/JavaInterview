package LeetCode_face01;

/**
 * @author 李杰
 * @version 1.0
 * @Description 搜索旋转数组
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/6/30 13:56
 * @title 标题: 搜索旋转数组
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class face10_03_1 {
    public int search(int[] arr, int target) {
//        [1,1,1,1,1,2,1,1,1]
//        2
        int left = 0;
        int right = arr.length - 1;
        if (right == -1)
            return -1;
        while (left < right) {                                         // 循环结束条件left==right
            int mid = left + (right - left) / 2;
            if (arr[left] < arr[mid]) {                              // 如果左值小于中值，说明左边区间升序
                if (arr[left] <= target && target <= arr[mid]) {     // 如果目标在左边的升序区间中，右边界移动到mid
                    right = mid;
                } else {                                               // 否则目标在右半边，左边界移动到mid+1
                    left = mid + 1;
                }
            } else if (arr[left] > arr[mid]) {                       // 如果左值大于中值，说明左边不是升序，右半边升序
                if (arr[left] <= target || target <= arr[mid]) {     // 如果目标在左边，右边界移动到mid
                    right = mid;
                } else {                                               // 否则目标在右半边，左边界移动到mid+1
                    left = mid + 1;
                }
            } else if (arr[left] == arr[mid]) {                      // 如果左值等于中值，可能是已经找到了目标，也可能是遇到了重复值
                if (arr[left] != target) {                            // 如果左值不等于目标，说明还没找到，需要逐一清理重复值。
                    left++;
                } else {                                               // 如果左值等于目标，说明已经找到最左边的目标值
                    right = left;                                      // 将右边界移动到left，循环结束
                }
            }
        }
        return (arr[left] == target) ? left : -1;

    }
}
