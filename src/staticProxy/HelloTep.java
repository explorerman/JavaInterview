package staticProxy;

public class HelloTep implements Hello{
    @Override
    public String sayHello(String str) {
       return "HelloTep" + str;
    }
}
