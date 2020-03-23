package LeetCode_stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//简化路径
public class number71 {
    // "/a/./b/../../c/"
    // "/c"
    //使用split先将字符串切分，然后处理单个字符串，如果栈不为空且等于“..”时，栈出栈
    //如果不等于
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] str = path.split("/");
        for (String t : str) {
            if(!stack.isEmpty() && t.equals("..")){
                stack.pop();
            }else if(!t.equals(".") && !t.equals("") && !t.equals("..")){
                stack.push(t);
            }
        }
        List<String> list = new ArrayList<>(stack);
        return "/" + String.join("/", list);
    }

    public static void main(String[] args) {
        new number71().simplifyPath("/a/./b/../../c/");
    }
}
