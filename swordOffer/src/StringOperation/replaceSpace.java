package StringOperation;

public class replaceSpace {

	public String replaceSpace(StringBuffer str) {
		int spaceNum = 0;
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == ' '){
				spaceNum++;
			}
		}
		int indexOld = str.length() - 1;
		int newLength = str.length() + spaceNum * 2;   //因为原来空格占一个位置，所以现在*2
		int indexNew = newLength - 1;
		str.setLength(newLength);
		for(; indexOld >= 0 && indexOld < newLength; --indexOld){
			if(str.charAt(indexOld) == ' '){
				str.setCharAt(indexNew--, '0');
				str.setCharAt(indexNew--, '2');
				str.setCharAt(indexNew--, '%');
			}else{
				str.setCharAt(indexNew--, str.charAt(indexOld));
			}
		}
		return str.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
