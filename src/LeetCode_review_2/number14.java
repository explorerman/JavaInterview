package LeetCode_review_2;

public class number14 {
    //    ["flower","flow","flight"]
    //"fl"
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        final char[] firstStr = strs[0].toCharArray();
        for (int i = 0; i < firstStr.length; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || firstStr[i] != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(firstStr[i]);
        }
        return sb.length() == 0 ? "" : sb.toString();
    }

}
