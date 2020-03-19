package java_basic;

//二进制转10进制
public class BinaryToTen {

	public static int addString(int a){
		while(a / 10 > 0){
			int sum = 0;
			while(a > 0)
			{
				sum += a % 10;
				a /= 10;
			}
			a = sum;
		}
		return a;
	}
	
	public static int addString2(int a){
		return (a == 0) ? 0 : (a-1) % 9 + 1;
	}
	
	public static void main(String[] args) {
		System.out.println(addString2(11));
	}

}
