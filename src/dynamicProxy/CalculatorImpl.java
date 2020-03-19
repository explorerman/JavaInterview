package dynamicProxy;

public class CalculatorImpl implements Calculator {

	private static final long serialVersionUID = 6943508377679638150L;

	@Override
	public void add(int a, int b) {
		System.out.println("a+b="+(a+b));
		
	}

	@Override
	public void subtract(int a, int b) {
		System.out.println("a-b="+(a-b));
	}


}
