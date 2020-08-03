package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 李杰
 * @version 1.0
 * @Description 快排
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/4/15 9:57
 * @title 标题: 快排
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        //把数据打乱
//        shuffle(nums);
        sort(nums, 0, nums.length - 1);
        for (T cur : nums){
            System.out.print(cur + " ");
        }
    }

    private void sort(T[] nums, int low, int high) {
        if (high <= low)
            return;
        //切分函数，左子数组小于切分元素j，右子数组大于切分元素j
        int index = partition(nums, low, high);
        //元素都小于j
        sort(nums, low, index - 1);
        //元素都大于j
        sort(nums, index + 1, high);
    }

    private void shuffle(T[] nums) {
        List<Comparable> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }

    private int partition(T[] nums, int low, int high) {
        int i = low, j = high + 1;
        //取low位置的元素为切分元素当做哨兵
        T sentinel = nums[low];
        while (true){
            //从左边找比切分元素大的第一个元素
            while (less(nums[++i], sentinel) && i != high);
            //从右边找比切分元素小的第一个元素
            while (less(sentinel, nums[--j]) && j != low);
            //循环出口
            if (i >= j)
                break;
            //找到后交换i和j
            swap(nums, i, j);
        }
        //交换切分元素和j，这样切分元素左边的元素都小于切分元素，右边的都大于切分元素。
        swap(nums, low, j);
        return j;
    }

    // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。快排切分的方法

    /**
     * 分三步：
     * 第一步：定义哨兵，一般选择左边第一个元素
     * 第二步：从数组左边找比哨兵小的第一个元素，右边找比元素大的第一个元素，找到后交换值。
     * 不断进行这个过程，就可以保证左指针 i 的左侧元素都不大于切分元素，右指针 j 的右侧元素都不小于切分元素。当两个指针相遇时，将切分元素 a[l] 和 a[j] 交换位置。
     * 第三步：将哨兵与j位置的元素交换后返回
     */
    private int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < v);
            while (--j >= lo && nums[j] > v);
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }


    public static void main(String[] args) {
        new QuickSort<Integer>().sort(new Integer[]{3,1,6,2,5,8,4,7});
//        System.out.println(new QuickSort<Integer>().less(1,1));
    }
}
