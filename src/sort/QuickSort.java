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
    }

    private void sort(T[] nums, int l, int h) {
        if (h <= l)
            return;
        int j = partition(nums, l, h);
        sort(nums, l, j - 1);
        sort(nums, j + 1, h);
    }

    private void shuffle(T[] nums) {
        List<Comparable> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }

    private int partition(T[] nums, int l, int h) {
        int i = l, j = h + 1;
        T v = nums[l];
        while (true){
            //从左边找比切分元素大的第一个元素
            while (less(nums[++i], v) && i != h);
            //从右边找比切分元素小的第一个元素
            while (less(v, nums[--j]) && j != l);
            //循环出口
            if (i >= j)
                break;
            //找到后交换i和j
            swap(nums, i, j);
        }
        //交换切分元素和j，这样切分元素左边的元素都小于切分元素，右边的都大于切分元素。
        swap(nums, l, j);
        return j;
    }

    public static void main(String[] args) {
//        new QuickSort<Integer>().sort(new Integer[]{3,1,6,2,5,8,4,7});
        System.out.println(new QuickSort<Integer>().less(1,1));
    }
}
