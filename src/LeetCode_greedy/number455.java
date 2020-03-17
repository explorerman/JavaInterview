package LeetCode_greedy;

import java.util.Arrays;

public class number455 {
    public int findContentChildren(int[] g, int[] s) {
        if(s.length == 0 || g.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int gLength = g.length -1;
        int sLength = s.length -1;
        int count = 0;
        while (gLength >=0 && sLength >= 0){
            if(s[sLength] >= g[gLength]){
                count++;
                sLength--;
                gLength--;
            }else{
                gLength--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] g = new int[]{10,9,8,7};
        int[] s = new int[]{5,6,7,8};

        new number455().findContentChildren(g,s);
    }

}
