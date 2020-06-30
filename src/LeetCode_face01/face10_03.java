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
public class face10_03 {
    public int search(int[] arr, int target) {
//        [1,1,1,1,1,2,1,1,1]
//        2
        int len = arr.length;
        int left = 0, right = len - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            //左边有序
            if(arr[left] < arr[mid]){
                if(arr[left] <= target && target <= arr[mid]){
                    right = mid;
                }else{
                    left = mid + 1;
                }
            }else if(arr[left] > arr[mid]){
                if(arr[left] <= target || target <= arr[mid]){
                    right = mid;
                }else {
                    left = mid + 1;
                }
            }else if(arr[left] == arr[mid]){
                if(arr[left] != target){
                    left++;
                }else {
                    right = left;
                }
            }
        }

        return arr[left] == target ? left : -1;

    }
}
