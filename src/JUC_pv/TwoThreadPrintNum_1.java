package JUC_pv;

/**
 * @author 李杰
 * @version 1.0
 * @Description 两个线程交叉打印1-100的数字
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/6/8 13:53
 * @title 标题: 两个线程交叉打印1-100的数字
 * 使用volatile + synchronized + wait + notifyAll
 * 缺点是：这种方法只能使用两个线程，如果要引入多线程，需要加序号
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class TwoThreadPrintNum_1 implements Runnable {
    private static volatile int i = 0;

    @Override
    public void run() {
        while (i < 100) {
            increase();
        }
    }

    public synchronized void increase() {
        notifyAll();
        i++;
        System.out.println(Thread.currentThread().getName() + i);
        try {
            if (i == 100) {
                notifyAll();
            } else {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TwoThreadPrintNum_1 twoThreadPrintNum_1 = new TwoThreadPrintNum_1();
        Thread t1 = new Thread(twoThreadPrintNum_1, "odd线程");
        Thread t2 = new Thread(twoThreadPrintNum_1, "even线程");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
