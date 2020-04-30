package chapter2;

/**
 * @author 李杰
 * @version 1.0
 * @Description volatile的不可见性
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/4/30 17:01
 * @title 标题: volatile的不可见性
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class NoVisibility {
    private static volatile boolean ready;
    private static int number;

    private static class ReaderThread extends Thread{

        @Override
        public void run() {
            while(!ready);
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        Thread.sleep(1000);
        number = 42;
        ready = true;
        Thread.sleep(1000);
    }
}
