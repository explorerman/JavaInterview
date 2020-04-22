package chapter4;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 李杰
 * @version 1.0
 * @Description
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/4/22 14:53
 * @title 标题:
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class AtomicIntegerDemo {
    static AtomicInteger i = new AtomicInteger();

    public static class AddThread implements Runnable {

        public void run() {
            for (int k = 0; k < 10000; k++) {
                i.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] ts = new Thread[10];
        for (int k = 0; k < 10; k++) {
            ts[k] = new Thread(new AddThread());
        }
        for (int k = 0; k < 10; k++) {
            ts[k].start();
        }
        for (int k = 0; k < 10; k++) {
            ts[k].join();
        }
        System.out.println(i);
    }
}
