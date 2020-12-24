package Stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * lambda表达式只能用来取代**函数接口（Functional Interface）**的简写，并且只能有一个重写方法，不然没办法自己猜出来。
 */
public class StreamExample {

    public static void main(String[] args) {
        //1.替代匿名内部类 不带参数的
        // 1.7新建线程的匿名内部类写法：省略了类名
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread run()");
            }
        }).start();

        // 1.8 直接使用lambda表达式：省略了类名，方法名
        new Thread(
                () -> {
                    System.out.println("hello");
                    System.out.println("world");
                }
        ).start();

        //2. 替代匿名内部类：带参数的
        //给一个字符串列表通过自定义比较器，按照字符串长度进行排序
        //jdk7 匿名内部类写法:省略了类名
        List<String> list = Arrays.asList("i","have", "a", "dream");
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        //jdk8 省略了类名和方法名,并且省略了参数的类型，因为可以自己猜出来
        Collections.sort(list, (s1, s2) ->{
            return s1.length() - s2.length();
        });


    }
}
