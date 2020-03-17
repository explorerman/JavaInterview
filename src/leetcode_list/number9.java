package leetcode_list;

public class number9 {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder(str);
        if(str.equals(sb.reverse().toString())){
            return true;
        }
        return false;
    }
    public static boolean isPalindrome2(int x) {
        String str = String.valueOf(x);
        int i = 0 , strLength = str.length(), j = strLength -1;
        boolean result = true;
        while (i < strLength && j < strLength) {
            if(str.charAt(i++) == str.charAt(j--)){
                continue;
            }else {
                result = false;
                return result;
            }
        }
        return result;
    }
    public static boolean isPalindrome3(int x) {
        int res = 0 ,source = x;
        if(x < 0) return false;
        while(x != 0){
            res = res * 10 + x % 10;
            x = x / 10;
        }
        if(source == res) return true;
        return false;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome3(121));
    }
}
