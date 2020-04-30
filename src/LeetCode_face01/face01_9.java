package LeetCode_face01;
//字符串轮转
public class face01_9 {
    public boolean isFlipedString(String s1, String s2) {
        if(s1.isEmpty() || s2.isEmpty()) return false;
        if(s1.equals(s2) || s1 == s2) return true;
        s1 += s1;
        if(s1.contains(s2)) return true;
        else{
            return false;
        }
    }

}
