package LeetCode_stack;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

//扁平化嵌套列表迭代器
//设计类，如何使用接口来写代码
//1.新建接口，接口中新增方法
//2.别的类中把接口当做类来使用，不用管接口中的方法是否实现。
//3.最后补全接口实现类
public class number341 implements Iterator<Integer> {
    private Stack<NestedInteger> stack = new Stack<>();
    public number341(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0 ; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        NestedInteger t = stack.peek();
        stack.pop();
        return t.getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()){
            NestedInteger t = stack.peek();
            if(t.isInteger()) return true;
            stack.pop();
            for (int i = t.getList().size() - 1; i >=0 ; i--) {
                stack.push(t.getList().get(i));
            }
        }
        return false;
    }
}
