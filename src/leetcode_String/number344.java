package leetcode_String;

public class number344 {
    public void reverseString(char[] s) {
        int length = s.length;
        for (int i = 0; i < s.length; i++) {
            char temp = s[i];
            s[i] = s[length - 1];
            s[length - 1] = temp;
            length--;
        }
    }
}
