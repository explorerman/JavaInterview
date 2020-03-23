package LeetCode_stack;

import java.util.Stack;

//逆波兰表达式求值
public class number150 {

    //单纯使用栈的特性，先入后出。复杂度太高，仅击败了全国百分之5的人
    public int evalRPN(String[] tokens) {
        int length = tokens.length;
        if(length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int left,right;
        int sum;
        for (int i = 0; i < length; i++) {
            if(isNumber(tokens[i])){
                stack.push(Integer.valueOf(tokens[i]));
            }else{
                if(!stack.isEmpty()){
                    right = stack.pop();
                    if(!stack.isEmpty()){
                        left = stack.pop();
                        sum = sum(right,left,tokens[i]);
                        stack.push(sum);
                    }
                }
            }
        }
        if(!stack.isEmpty()){
            return stack.pop();
        }else{
            return 0;
        }
    }

    //工具类：正则表达式判断是否是数字，包含正数，小数，负数
    private boolean isNumber(String token) {
        Boolean strResult = token.matches("-?[0-9]+.?[0-9]*");
        if(strResult == true) {
           return true;
        } else {
            return false;
        }
    }

    private int sum(int right, int left, String token) {
        int sum = 0;
        if("+".equals(token)){
            sum = left + right;
        }
        if("-".equals(token)){
            sum = left - right;
        }
        if("*".equals(token)){
            sum = left * right;
        }
        if("/".equals(token)){
            sum = left / right;
        }
        return sum;
    }

    public static void main(String[] args) {
        new number150().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
    }

}
