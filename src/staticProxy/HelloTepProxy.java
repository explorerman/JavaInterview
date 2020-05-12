package staticProxy;

public class HelloTepProxy implements Hello{
    private Hello proxy = new HelloTep();
    @Override
    public String sayHello(String str) {
        return proxy.sayHello(str);
    }
}
