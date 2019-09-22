package TimerTest;

public class TryTest {

	@SuppressWarnings("finally")
	public static int test(){
		int i = 0;
		int j = 0;
		try{
			i += 1;
			System.out.println("try里面打印i值=" +i);
			return j;
		}catch(Exception e){
		}finally{
			j = i+1;
			System.out.println("finally里面打印i值=" + i +"和j值="+j);
			return j;
		}
	}
	public static void main(String[] args) {
		int i = test();
		System.out.println("最终结果返回的值="+i);
	}
}
