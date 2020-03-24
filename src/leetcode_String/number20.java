package leetcode_String;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
//有效的括号
public class number20 {
//    思路：使用栈来完成匹配，遍历字符串，将其中左半部分压入栈，将栈顶元素与与遍历的字符串对比，若符合要求，则出栈。
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
        if (a == '{' && b=='}') {
            return true;
        }else if(a =='('&& b ==')'){
            return true;
        }else return a == '[' && b == ']';
    }

//    使用hashmap保存匹配的字符串：
private static final Map<Character, Character> map = new HashMap<Character, Character>(){
    {
        put('{','}'); put('[',']'); put('(',')');
    }
};

    public static boolean isValid2(String s){
        if(s.length() > 0 && !map.containsKey(s.charAt(0))) return false; //如在map中没有，则直接返回false
        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()){
            if(stack.isEmpty() || map.containsKey(c)) stack.push(c);
            else if(map.get(stack.peek()) == c) stack.pop();
            else return false;
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String s = "()[]{}";
        String s1 = ")[)]";
        boolean is = isValid2(s1);
        System.out.println(is);
    }
}
