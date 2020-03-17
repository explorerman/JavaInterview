package LeetCode_findtable;

import java.util.HashSet;
import java.util.Set;

//快乐数
public class number202 {
    //使用hashset,分析快乐数和非快乐数的区别，非快乐数会出现结果的周期性重复出现
    //所以只需要不停的求每位数的平方和，如果没有出现相同的数，则加入set，如果出现了直接返回
    //执行用时 :
    //2 ms, 在所有 Java 提交中击败了61.26%的用户
    //内存消耗 :
    //37.5 MB, 在所有 Java 提交中击败了5.02%的用户
    public boolean isHappy(int n) {
        Set<Integer> set  = new HashSet<>();
        while (n != 1){
            int sum = 0;
            while (n != 0){
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
            if(!set.contains(n)){
                set.add(n);
            }else {
                break;
            }
        }
        return n == 1;
    }
}
