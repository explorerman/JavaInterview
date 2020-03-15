package LeetCode_array;

//移除元素
public class number27 {
    //nums = [0,1,2,2,3,0,4,2], val = 2,  函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
    //还是双指针，一个元素用来迭代遍历，一个元素用来记录最后要返回的值
    public int removeElement(int[] nums, int val) {
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != val) nums[res++] = nums[i];
        }
        return res;
    }



    public static void main(String[] args) {
        new number27().removeElement(new int[]{0,1,2,2,3,0,4,2},2);
    }
}
