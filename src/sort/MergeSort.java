package sort;

/**
 * @author 李杰
 * @version 1.0
 * @Description 归并排序，也就是分治算法的最好应用
 * 归并是先细分在合并，二分是先分区在在分
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/8/3 17:29
 * @title 标题: 归并排序，也就是分治算法的最好应用
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class MergeSort {


    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int low, int hight) {
        if (hight < low) return;
        int mid = low + (hight - low) / 2;
        sort(nums, low, mid);
        sort(nums, mid + 1, hight);
        merge(nums, low, mid, hight);
    }

    private void merge(int[] nums, int low, int mid, int hight) {
        int[] aux = new int[hight - low + 1];
        int i = low, j = mid + 1;

        for (int k = low; k <= hight; k++) {
            aux[k] = nums[k]; // 将数据复制到辅助数组
        }

        for (int k = low; k <= hight; k++) {
            if (i > mid) {
                nums[k] = aux[j++];

            } else if (j > hight) {
                nums[k] = aux[i++];

            } else if (aux[i] < aux[j]) {
                nums[k] = aux[i++]; // 先进行这一步，保证稳定性

            } else {
                nums[k] = aux[j++];
            }
        }
    }


    private void merge2(int[] nums, int low, int mid, int hight) {
        int[] result = new int[hight - low + 1];
        int start1 = low, end1 = mid;
        int start2 = mid + 1, end2 = hight;
        int k = low;
        while (start1 <= end1 && start2 <= end2) {
            result[k++] = nums[start1] < nums[start2] ? nums[start1++] : nums[start2++];
        }
        while (start1 <= end1) {
            result[k++] = nums[start1++];
        }
        while (start2 <= end2) {
            result[k++] = nums[start2++];
        }
        for (int i = low; i <= hight; i++) {
            nums[i] = result[i];
        }

    }


}
