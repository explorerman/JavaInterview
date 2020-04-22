package chapter4;

/**
 * @author 李杰
 * @version 1.0
 * @Description 线程本地变量例子1
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/4/22 9:23
 * @title 标题: 线程本地变量例子1
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class ThreadLocalExample {
    public static void main(String[] args) {
        ThreadLocal threadLocalx = new ThreadLocal();
        ThreadLocal threadLocaly = new ThreadLocal();
        Thread thread1 = new Thread(() -> {
            threadLocalx.set(1);
            threadLocaly.set(1);
//            System.out.println(threadLocalx.get());
        });
        Thread thread2 = new Thread(() -> {
            threadLocalx.set(2);
            threadLocaly.set(2);
            System.out.println(threadLocalx.get());
            System.out.println(threadLocaly.get());
        });
        thread1.start();
        thread2.start();
    }
}
