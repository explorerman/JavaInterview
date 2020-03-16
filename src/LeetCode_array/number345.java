package LeetCode_array;

//反转字符串中的元音字母
public class number345 {
    //输入: "hello"
    //输出: "holle"
    //输入: "leetcode"
    //输出: "leotcede"
    //解题思路：双指针
    public String reverseVowels(String s) {
        int length = s.length();
        if(length == 0) return "";
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left <= right){
            if(isVowel(chars[left]) && isVowel(chars[right])){
                swap(chars, left++, right--);
            }else if(!isVowel(chars[left])){
                left++;
            }else if(!isVowel(chars[right])){
                right--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char str : chars){
            sb.append(str);
        }
        return sb.toString();
    }

    private void swap(char[] chars, int left, int right) {
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
    }

    private boolean isVowel(char aChar) {
        if(aChar == 'a' || aChar == 'A' ||aChar == 'e' ||aChar == 'E' ||aChar == 'i' ||
                aChar == 'I' || aChar == 'o' || aChar == 'O' || aChar == 'u'|| aChar == 'U'){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new number345().reverseVowels("hello"));
    }
}
