package LeetCode_Concurrency;

import java.util.concurrent.Semaphore;

/**
 * @author 李杰
 * @version 1.0
 * @Description 交替打印FooBar, 使用信号量
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/6/9 15:58
 * @title 标题: 交替打印FooBar LeetCode_1115
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class FooBar {
    private int n;

    private Semaphore foo = new Semaphore(1);
    private Semaphore bar = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            foo.acquire();
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            bar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            foo.release();
        }
    }

    public static void main(String[] args) {
        FooBar fb = new FooBar(4);

        new Thread() {
            public void run() {
                try {
                    fb.foo(new Runnable() {

                        @Override
                        public void run() {
                            System.out.println("foo");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            public void run() {
                try {
                    fb.bar(new Runnable() {

                        @Override
                        public void run() {
                            System.out.println("bar");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
