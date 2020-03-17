package leetcode_backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class number22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n < 0) return res;
        generateParenthesisBackTracking(res,"", n);
        return res;
    }
    public void generateParenthesisBackTracking(List<String> res, String level, int n){
        if(level.length() == n * 2 && isValid(level)){
            res.add(level);
            return;
        }
    }
    public  boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] str = s.toCharArray();
        for(char i : str){
            //如果是空栈直接进栈
            //如果不匹配也进栈
            if(stack.isEmpty() || !isCompare(stack.peek(), i)){
                stack.push(i);
            }
            //匹配出栈
            else if(isCompare(stack.peek(), i)){
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    //匹配函数
    public  boolean isCompare(char a, char b){
        if (a == '(' && b==')') {
            return true;
        }
        return false;
    }
}
