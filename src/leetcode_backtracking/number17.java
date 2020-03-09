package leetcode_backtracking;

import java.util.ArrayList;
import java.util.List;

//电话号码的字母组合
public class number17 {

    private String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    List<String> res;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if(digits.equals("")) return res;

        findCombinations(digits, 0 , "");
        return res;
    }
    //s中保存了此时从digits[0...index-1]翻译得到的一个字符串
    //寻找和digits[index]匹配的字母，获得gigits(0...index)翻译得到的解
    private void findCombinations(String digits, int index, String s){
        if(index == digits.length()){
            res.add(s);
            return;
        }
        char c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for(int i = 0 ; i < letters.length() ; i ++){
            findCombinations(digits, index+1, s + letters.charAt(i));
        }
        return;
    }

    public static void main(String[] args) {
        new number17().letterCombinations("23");
    }
}
