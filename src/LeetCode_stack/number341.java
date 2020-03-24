package LeetCode_stack;

import java.util.Iterator;
import java.util.List;

//扁平化嵌套列表迭代器
public class number341 implements Iterator<Integer> {
    public number341(List<number341> nestedList) {

    }

    @Override
    public Integer next() {
        return 0;
    }

    @Override
    public boolean hasNext() {
        return false;
    }
}
