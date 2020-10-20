package BIO;

public class QuickSort{
    public void sort(int[] nums){
        sort(nums, 0, nums.length - 1);
        for(int cur : nums){
            System.out.println(cur + " ");
        }
    }

    private void sort(int[] nums, int low, int high) {
        if(low >= high){
            return;
        }
        int index = partition(nums, low, high);
        sort(nums, 0, index -1);
        sort(nums, index + 1, high);

    }

    private int partition(int[] nums, int left, int right) {
        int sentinel = nums[left];
        while (left < right){
            while (left < right && !less(nums[right], sentinel)){
                right--;
            }
            nums[left] = nums[right];
            while (left < right && !less(sentinel,nums[left])){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = sentinel;
        return left;
    }

    private boolean less(int num, int sentinel) {
        return num > sentinel;
    }

    public static void main(String[] args) {
        new QuickSort().sort(new int[]{3,1,6,2,5,8});
    }

}
