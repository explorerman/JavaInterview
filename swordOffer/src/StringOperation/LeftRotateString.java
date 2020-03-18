package StringOperation;

public class LeftRotateString {

	//�÷������ַ���ƴ��
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
		reverse(s, 0, n - 1);  //��nǰ��ķ�ת
		reverse(s, n, len - 1);  //��n-β���ķ�ת
		return reverse(s, 0, len - 1);  //���µ��ַ�����ת��Ϊ��ĿҪ��
	}
	public static void main(String[] args) {
		System.out.println(new LeftRotateString().LeftRotateString2("abcXYZdef", 3));
	}

}
