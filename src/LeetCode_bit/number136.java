package LeetCode_bit;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//只出现一次的数字
public class number136 {
    //思路1：笨办法：没有满足题目要求，题目要求不使用额外空间，但本方法中使用了hashmap
    //将出现过的数放进map中，若后续在出现，则移除，最后剩下的只有出现一次的数字了，最后
    //使用迭代器遍历map的key，将结果输出。
    public int singleNumber1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
                continue;
            }
            map.remove(nums[i]);
        }
        Iterator<Integer> iter = map.keySet().iterator();
        while(iter.hasNext()){
            result = iter.next();
        }
        return result;
    }


//    思路2：不使用额外空间的话，考虑使用位运算 bit operation。
//    标签：位运算
//    本题根据题意，线性时间复杂度 O(n)，很容易想到使用 Hash 映射来进行计算，遍历一次后结束得到结果，但是在空间复杂度上会达到 O(n)，需要使用较多的额外空间
//    既满足时间复杂度又满足空间复杂度，就要提到位运算中的异或运算 XOR，主要因为异或运算有以下几个特点：
//    一个数和 0 做 XOR 运算等于本身：a⊕0 = a
//    一个数和其本身做 XOR 运算等于 0：a⊕a = 0
//    XOR 运算满足交换律和结合律：a⊕b⊕a = (a⊕a)⊕b = 0⊕b = b
//    故而在以上的基础条件上，将所有数字按照顺序做抑或运算，最后剩下的结果即为唯一的数字
//    时间复杂度：O(n)，空间复杂度：O(1)
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,1,0,1,99};
        new number136().singleNumber(nums);
    }
}
