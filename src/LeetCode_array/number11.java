package LeetCode_array;

//盛最多水的容器
public class number11 {
    /**
     * 数组的下标可以当坐横坐标，值可以是纵坐标
     * 面积最大：横坐标*纵坐标
     * 思路：
     * 暴力破解法：列举所有的情况，不断更新最大值
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        if(height.length < 2)  return -1;
        int maxAreaOne = Integer.MIN_VALUE;
        int maxAreaTwo = Integer.MIN_VALUE;
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < height.length;i++){
            for(int j = i+1; j < height.length;j++){
                if(height[i] < height[j]){
                    maxAreaOne = Math.max(height[i]*(j-i), maxAreaOne);
                }else{
                    maxAreaOne = Math.max(height[j]*(j-i), maxAreaOne);
                }
            }
            maxArea = Math.max(maxAreaOne, maxArea);
            maxAreaOne = Integer.MIN_VALUE;
        }
        return maxArea;
    }

    public static void main(String[] args) {
//		int[] nums = new int[]{1,2,4,3};
        int[] nums = new int[]{1,8,6,2,5,4,8,3,7};
        int result = maxArea(nums);
        System.out.println(result);

    }
}
