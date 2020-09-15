package leetcode_String;

import java.util.ArrayList;
import java.util.List;

/**
 * Z字形变换
 *  方法：使用flag标志，根据题意，模拟这个行索引的变化，在遍历 s 中把每个字符填到正确的行 res[i] 。
 *  复杂度分析：
 *      时间复杂度 O(N) ：遍历一遍字符串 s；
 *      空间复杂度 O(N) ：各行字符串共占用 O(N) 额外空间。
 */
public class number6 {
    public String convert(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<>();
        //构造出numRows长度的数组
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0, flag = - 1;
        for (char cur : s.toCharArray()){
            rows.get(i).append(cur);
            if(i == 0 || i == numRows - 1){
                //当碰到首行和尾行的时候，改变方向，继续遍历
                flag = - flag;
            }
            //控制i元素，让s中当前的元素存到对应的数组中
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows){
            res.append(row);
        }
        return res.toString();
    }
}
