package leetcode_list;

public class number8 {
    public static int myAtoi(String str) {
        if(str.isEmpty()) return 0;
        if(str.trim().isEmpty()) return 0;
        int flag = 1, result = 0, strLength = str.length(), i = 0;
        while(i < strLength && str.charAt(i)==' ') ++i;
        if(str.charAt(i) == '+' || str.charAt(i) == '-'){
            flag = (str.charAt(i++) == '+') ? 1 : -1;
        }
        while(i < strLength && str.charAt(i) -'0'>= 0 && str.charAt(i) - '0' <= 9){
            if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && (str.charAt(i) - '0' > 7))){
                return (flag == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + str.charAt(i++) - '0';
        }
        return result * flag;
    }

    public static void main(String[] args) {
       System.out.println(myAtoi("-91283472332"));
    }
}
