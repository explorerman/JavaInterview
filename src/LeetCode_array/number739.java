package LeetCode_array;

import java.util.Stack;

public class number739 {
    //暴力破解法
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if(T[j] > T[i]){
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    //构造递减栈
    //temperatures = [73, 74, 75, 71, 69, 72, 76, 73]
    public int[] dailyTemperatures2(int[] T) {
        int len = T.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]){
                int t = stack.pop();
                res[t] = i - t;
            }
            stack.push(i);
        }
        return res;
    }

}
