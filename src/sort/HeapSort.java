package sort;

/**
 * @author 李杰
 * @version 1.0
 * @Description 堆排序
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/4/15 15:58
 * @title 标题: 堆排序
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class HeapSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        int N = nums.length - 1;
        for (int k = N / 2; k >= 1; k--)
            sink(nums, k, N);

        while (N > 1) {
            swap(nums, 1, N--);
            sink(nums, 1, N);
        }
        System.out.println(nums);
    }

    private void sink(T[] nums, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(nums, j, j + 1))
                j++;
            if (!less(nums, k, j))
                break;
            swap(nums, k, j);
            k = j;
        }
    }

    private boolean less(T[] nums, int i, int j) {
        return nums[i].compareTo(nums[j]) < 0;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1,10,9,8, 2, 3, 6, 4, 5, 11, 7};
        new HeapSort<Integer>().sort(nums);
//        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });
//        pq.addAll(Arrays.asList(nums));
//        System.out.println(pq);
    }

}
