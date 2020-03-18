package StringOperation;

public class LeftRotateString {

	//该方法是字符串拼接
	public String LeftRotateString(String str,int n) {
		if(str.length() == 0 || 0 == n) return str;
		StringBuilder sb = new StringBuilder();
		char[] s = str.toCharArray();
		for(int i = n; i < s.length; i++){
			sb.append(s[i]);
		}
		for(int i = 0; i < n; i++){
			sb.append(s[i]);
		}
        return sb.toString();
    }
	public String reverse(char[] s, int start, int end){
		char temp;
		while(start < end){
			temp = s[start];
			s[start] = s[end];
			s[end] = temp;
			start++;
			end--;
		}
		return new String(s);
	}
	public String LeftRotateString2(String str,int n) {
		int len = str.length();
		if(len == 0 || 0 == n) return str;
		char[] s = str.toCharArray();
		reverse(s, 0, n - 1);  //将n前面的反转
		reverse(s, n, len - 1);  //将n-尾部的反转
		return reverse(s, 0, len - 1);  //将新的字符串反转即为题目要求
	}
	public static void main(String[] args) {
		System.out.println(new LeftRotateString().LeftRotateString2("abcXYZdef", 3));
	}

}
