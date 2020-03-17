package LeetCode_findtable;

import java.util.*;

//根据字符串出现频率排序
public class number451 {
    //tree
    //eert
    //思路：将字符串放入hashmap，并按照value排序，若value大于1时，得写个内部循环，将相对于的key加进去。
    //执行用时 :
    //38 ms, 在所有 Java 提交中击败了23%的用户
    //内存消耗 :
    //42.2 MB, 在所有 Java 提交中击败了5.39%的用户
    public String frequencySort(String s) {
        int length = s.length();
        if(length == 0) return "";
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char cur : chars) {
            if(!map.containsKey(cur)){
                map.put(cur,1);
            }else{
                map.put(cur,map.get(cur)+1);
            }
        }

        //以下是对hashmap中对value排序,对list进行排序，并通过Comparator传入自定义的排序规则
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        //用迭代器对list中的键值对元素进行遍历
        Iterator<Map.Entry<Character, Integer>> iter = list.iterator();
        StringBuilder sb = new StringBuilder();
        while(iter.hasNext()){
            Map.Entry<Character, Integer> item = iter.next();
            int value = item.getValue();
            if(value != 1){
                for (int i = 0; i < value; i++) {
                    sb.append(item.getKey());
                }
            }else{
                sb.append(item.getKey());
            }
//            Character key = item.getKey();
//            int value = item.getValue();
//            System.out.println("键"+key+"值"+value);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new number451().frequencySort("treeE"));
    }
}
