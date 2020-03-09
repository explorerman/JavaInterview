package LeetCode_BinarySearch;

//两数之和 II - 输入有序数组
public class number167 {
    //输入: numbers = [2, 7, 11, 15], target = 9
    //输出: [1,2]
    //解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。

    //双指针,时间复杂度为n
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if(numbers.length == 0) return res;
        int left = 0, right = numbers.length -1;
        while (left <= right){
            if(target == (numbers[left]+numbers[right])){
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }else if(target > (numbers[left]+numbers[right])){
                left++;
            }else if(target < (numbers[left] + numbers[right])){
                right--;
            }
        }
        return res;
    }

    //二分 时间复杂度为：nlog(n)
    public int[] twoSum2(int[] numbers, int target){
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int t = target - numbers[i];
            int left = i + 1, right = numbers.length;
            while (left < right){
                int mid = left + (right - left) / 2;
                if(numbers[mid] == t){
                    res[0] = i+1;
                    res[1] = mid + 1;
                    return res;
                }else if(numbers[mid] > t){
                    right = mid;
                }else {
                    left = mid +1;
                }
            }
        }
        return res;
    }
}
