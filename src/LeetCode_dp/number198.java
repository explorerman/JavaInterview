package LeetCode_dp;
//打家劫舍
public class number198 {
//    思路：定义两个奇偶变量，分别求走到奇偶位置时的最大值
        public  int rob(int[] nums) {
            int max = Integer.MIN_VALUE;
            int evenMax = 0;
            int oddMax = 0;
            int len = nums.length;
            if(len <= 0) return 0;
            for(int i = 0; i < nums.length;i++){
                if(i % 2 == 0){
                    //只是确定要抢偶数位，最终值并不一定是偶数位置的值，并且最终能保证最大值的数字不相邻
                    evenMax = Math.max(evenMax + nums[i], oddMax);
                }else{
                    oddMax = Math.max(oddMax + nums[i], evenMax);
                }
            }
            max = Math.max(evenMax, oddMax);
            return max;
        }


//    思路2：当做典型动态规划
//    标签：动态规划
//    动态规划方程：dp[n] = MAX( dp[n-1], dp[n-2] + num )
//    由于不可以在相邻的房屋闯入，所以在当前位置 n 房屋可盗窃的最大值，要么就是 n-1 房屋可盗窃的最大值，要么就是 n-2 房屋可盗窃的最大值加上当前房屋的值，二者之间取最大值
//    举例来说：1 号房间可盗窃最大值为 33 即为 dp[1]=3，2 号房间可盗窃最大值为 44 即为 dp[2]=4，3 号房间自身的值为 22 即为 num=2，那么 dp[3] = MAX( dp[2], dp[1] + num ) = MAX(4, 3+2) = 5，3 号房间可盗窃最大值为 55
//    时间复杂度：O(n)O(n)，nn 为数组长度
        public int rob2(int[] nums) {
            int len = nums.length;
            if(len == 0)
                return 0;
            int[] dp = new int[len + 1];
            dp[0] = 0;
            dp[1] = nums[0];
            for(int i = 2; i <= len; i++) {
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
            }
            return dp[len];
        }
}
