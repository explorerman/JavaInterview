package java_basic;

//测试this和super关键字的范围
class Father2{
	private void print(){
		System.out.println("father");
	}
	public void funFather(){
		this.print();
	}
}
class Child2 extends Father2{
	void print(){
		System.out.println("child");
	}
	public void funChild(){
		this.print();
	}
}
public class TestThisAndSuper2 {

	public static void main(String[] args) {
		Child2 c = new Child2();
		c.funFather();
		System.out.println("---------------");
		c.funChild();
	}

}
