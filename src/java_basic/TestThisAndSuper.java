package java_basic;

class GrandFather{
	public void print(){
		System.out.println("GrandFather");
	}
}
class Father extends GrandFather{
	@Override
	public void print(){
		System.out.println("Father");
	}
	public void funFather(){
		this.print();
		super.print();
	}
}
class Child extends Father{
	@Override
	public void print(){
		System.out.println("Child");
	}
	public void funChild(){
		this.print();
		super.print();
	}
}
public class TestThisAndSuper {

	
	public static void main(String[] args) {
		//˵��this����ָ����ø÷����Ķ���
		//superָ�����ô��������������ֱ�Ӹ���
		Child c = new Child();
		c.funFather();
		System.out.println("---------------");
		c.funChild();
	}
}
