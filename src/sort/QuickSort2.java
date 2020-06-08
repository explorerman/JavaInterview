package sort;

/**
 * @author 李杰
 * @version 1.0
 * @Description 快速排序2
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/6/8 16:30
 * @title 标题: 快速排序2
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class QuickSort2<T extends Comparable<T>> extends Sort<T>{

    @Override
    public void sort(T[] nums) {
        sort(nums, 0, nums.length - 1);
        for (T cur : nums){
            System.out.print(cur + " ");
        }
    }

    private void sort(T[] nums, int low, int high) {
        if(low >= high){
            return;
        }
        int index = partition(nums, low, high);
        sort(nums, 0, index - 1);
        sort(nums, index + 1, high);
    }

    private int partition(T[] nums, int left, int right) {
        T sentinel = nums[left];
        while (left < right){
            //如果右边元素比哨兵大，则right--
            while (left < right && !less(nums[right],sentinel)){
                right--;
            }
            //如果有小于哨兵的，则把right处的值放到left处
            nums[left] = nums[right];
            //如果左边元素比哨兵小，则left++
            while (left < right && less(nums[left], sentinel)){
                left++;
            }
            //如果左边元素大于哨兵，则放在右边right位置
            nums[right] = nums[left];
        }
        //把哨兵放到left处，这时候，left左边的元素都比哨兵小，右边的都比哨兵大
        nums[left] = sentinel;
        return left;
    }

    public static void main(String[] args) {
        new QuickSort2<Integer>().sort(new Integer[]{3,1,6,2,5,8,4,7});
    }
}
