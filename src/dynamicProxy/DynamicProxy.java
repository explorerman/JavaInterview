package dynamicProxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {

	public static void main(String[] args) throws Throwable {

		CalculatorImpl target = new CalculatorImpl();
		Calculator calculator = (Calculator) getProxy2(target);
		calculator.add(1, 2);
		calculator.subtract(3, 1);
	}

	private static Object getProxy(final Object target) throws Exception{
		Class proxyClass = Proxy.getProxyClass(target.getClass().getClassLoader(), target.getClass().getInterfaces());
		Constructor constructor = proxyClass.getConstructor(InvocationHandler.class);
		Object proxy = constructor.newInstance(new InvocationHandler(){

			/**
			 * Object proxy:第一个参数是前面Proxy.newProxyInstance()创建的代理对象, 一般我们无需对其进行操作.
			 * 这个参数用于 invoke方法选择 调用方法用的 具体解释是 当proxy生成字节码时 会调用invoke方法
			 * 你自己想实现的额外逻辑写在一个类中，通过这个proxy传进来就好了啊，
			 * 其实这里的method args都还可以做一下收集以实现不同方法植入不同的逻辑
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println(method.getName()+"方法开始执行。。。。。。");
				Object result = method.invoke(target,args);
				System.out.println(method.getName()+"方法执行结束。。。。。。");
				return result;
			}

		});
		return proxy;
	}
	private static Object getProxy2(final Object target) throws Exception{
		Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
				new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println(method.getName()+"方法开始执行。。。。。。");
						Object result = method.invoke(target,args);
						System.out.println(method.getName()+"方法执行结束。。。。。。");
						return result;
					}
				});
		return proxy;
	}

}
