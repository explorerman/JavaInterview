package LeetCode_bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//打开转盘锁
//使用bfs
public class number752 {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        // 记录需要跳过的死亡密码
        Set<String> deads = new HashSet<>();
        for (String cur : deadends){
            deads.add(cur);
        }
        // 记录已经穷举过的密码，防止走回头路
        Set<String> visited = new HashSet<>();
        // 从起点开始启动广度优先搜索
        int step = 0;
        queue.offer("0000");
        visited.add("0000");
        while (!queue.isEmpty()){
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                final String cur = queue.poll();
                //判断是否到达终点
                if(deads.contains(cur)) continue;
                if(cur.equals(target)) return step;
                //将第一个节点的相邻节点加入队列,
//                如果你只转一下锁，有几种可能？总共有 4 个位置，每个位置可以向上转，也可以向下转，也就是有 8 种可能对吧。
//                比如说从 "0000" 开始，转一次，可以穷举出 "1000", "9000", "0100", "0900"... 共 8 种密码。然后，再以这 8 种密码作为基础，对每个密码再转一下，
//                穷举出所有可能...
//                仔细想想，这就可以抽象成一幅图，每个节点有 8 个相邻的节点，又让你求最短距离
                for (int j = 0; j < 4; j++) {
                    final String up = plusOne(cur, j);
                    if(!visited.contains(up)){
                        queue.offer(up);
                        visited.add(up);
                    }
                    final String down = minusOne(cur, j);
                    if(!visited.contains(down)){
                        queue.offer(down);
                        visited.add(down);
                    }

                }
            }
            /* 在这里增加步数 */
            step++;
        }
        // 如果穷举完都没找到目标密码，那就是找不到了
        return -1;
    }
    // 将 cur[i] 向下拨动一次
    private String minusOne(String cur, int j) {
        final char[] chars = cur.toCharArray();
        if(chars[j] == '0') chars[j] = '9';
        else chars[j] -= 1;
        return new String(chars);
    }

    // 将 cur[j] 向上拨动一次
    private String plusOne(String cur, int j) {
        final char[] chars = cur.toCharArray();
        if(chars[j] == '9') chars[j] = '0';
        else chars[j] += 1;
        return new String(chars);
    }
}
