package LeetCode_dp;

//跳跃游戏
//其中 dp[i] 表示达到i位置时剩余的跳力，若到达某个位置时跳力为负了，说明无法到达该位置
//到达当前位置的剩余跳力跟什么有关呢，其实是跟上一个位置的剩余跳力（dp 值）和上一个位置新的跳力（nums 数组中的值）有关，这里新的跳力就是原数组中每个位置的数字，
// 因为其代表了以当前位置为起点能到达的最远位置。
// 所以当前位置的剩余跳力（dp 值）和当前位置新的跳力中的较大那个数决定了当前能到的最远距离，而下一个位置的剩余跳力（dp 值）就等于当前的这个较大值减去1
public class number55 {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 1]) - 1;
            if (dp[i] < 0) return false;
        }
        return true;
    }
}
