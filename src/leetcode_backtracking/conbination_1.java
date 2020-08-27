package leetcode_backtracking;

//蚂蚁金服二面算法题：3.输入一个字符串，输出该字符串中字符的所有组合。举个例子，如果输入abc，它的组合有a、b、c、ab、ac、bc、abc
public class conbination_1 {
    public static void combine(String str) {
        if (str == null)
            return;
        int length = str.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            //i即为字符串的组合中最长字符的长度
            combination(str, 0, i, sb);
        }
    }
    //index控制字符串中的索引，number用来控制组合字符串的长度即a,ab,abc等
    public static void combination(String str, int index, int number,
                                   StringBuilder sb) {
        //回溯的出口
        if (number == -1) {
            System.out.println(sb.toString());
            return;
        }
        //控制index的边界
        if (index == str.length())
            return;

        sb.append(str.charAt(index));

        //递归进行下一步的操作
        combination(str, index + 1, number - 1, sb);
        //撤销上一步的操作
        sb.deleteCharAt(sb.length() - 1);
        //撤销后再次进入最开始外函数调用的情况，只是index+1，因为index是控制字符串的索引
        combination(str, index + 1, number, sb);

    }



    public static void main(String[] args) {
        combine("abc");
    }
}
