package LeetCode_weeks_179;

public class week179_1 {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if(n % 2 == 1){
            for (int i = 0; i < n; i++) {
                sb.append("a");
            }
            return sb.toString();
        }else{
            sb.append("b");
            n--;
            for (int i = 0; i < n; i++) {
                sb.append("a");
            }
            return sb.toString();
        }
    }
}
