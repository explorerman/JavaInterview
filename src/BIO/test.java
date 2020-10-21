package BIO;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;


/**
 * 使用单调栈  快手二面算法题
 */
public class test {
//    abcaa$d --> abcd
//    abac$aa$ ---> ab

    public String testa(String str){
        StringBuffer res = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '$'){
               char temp = stack.peek();
               stack.pop();
               while(stack.size() != 0 && temp == stack.peek()){
                   stack.pop();
               }
               continue;
            }
            stack.push(str.charAt(i));
        }
        final Iterator<Character> iterator = stack.iterator();
        while (iterator.hasNext()){
            res.append(iterator.next());
        }
        System.out.println(res.toString());
        return res.toString();
    }

    public static void main(String[] args) {
        new test().testa("abac$aa$");
    }

}
