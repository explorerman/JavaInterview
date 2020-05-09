package LeetCode_byte_dance;

import java.util.ArrayList;
import java.util.List;

//复原ip
public class number93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        backtrace(s, 0, cur, 0, res);
        return res;
    }

    // depth控制递归深度
    public void backtrace(String s, int index, StringBuilder cur, int depth, List<String> res) {
        int len = cur.length();
        if(depth == 4) {
            // 如果字符串都取完了，可以加入结果集
            if(index == s.length()) {
                // 移除掉最后的"."
                cur.deleteCharAt(cur.length() - 1);
                res.add(cur.toString());
            }
            return;
        }
        // 每组ip地址的长度，最大为3
        for(int i = 1; i <= 3; i++) {
            if(index + i > s.length()) break;
            // 注意ip数字的合法性，不能大于255
            if(Integer.parseInt(s.substring(index, index + i)) > 255) break;
            int num = Integer.parseInt(s.substring(index, index + i));
            // 不能存在01.001.01.01
            if(String.valueOf(num).length() != i) break;
            cur.append(s.substring(index, index + i));
            cur.append(".");
            backtrace(s, index + i, cur, depth + 1, res);
            cur.setLength(len);
        }
    }
}
