package StringOperation;

public class StrToInt {

	// µœ÷Integer.valueOf(String);
	public int strToInt(String str){
		if(str.length() == 0 || str.equals("")) return 0;
		char[] a = str.toCharArray();
		int negative = 0;
		long sum = 0;
		if(a[0] == '-'){
			negative = 1;
		}
		for(int i = negative; i < a.length; i++){
			if(a[i] == '+') continue;
			if(a[i] < 48 || a[i] > 57) return 0;
			sum = sum * 10 + a[i] - 48;
			if((negative == 0 && sum > Integer.MAX_VALUE) || (negative == 1 && sum * negative < Integer.MIN_VALUE) ){
				return 0;
			}
		}
		return negative == 0 ? (int)sum : (int)sum * -1;
	}
	public int abc(String str){
		return Integer.valueOf(str);
	}
	public static void main(String[] args) {
		System.out.println(new StrToInt().strToInt("-2147483647"));
	}
}
