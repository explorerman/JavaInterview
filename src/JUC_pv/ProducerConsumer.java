package JUC_pv;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author 李杰
 * @version 1.0
 * @Description 阻塞队列
 * FIFO 队列 ：LinkedBlockingQueue、ArrayBlockingQueue（固定长度）
 * 优先级队列 ：PriorityBlockingQueue
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/4/21 10:12
 * @title 标题: 阻塞队列
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class ProducerConsumer  {
    
    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

    private static class Product extends Thread {
        @Override
        public void run() {
            try {
                queue.put("生产者");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("生产者。。。。");
        }
    }

    private static class Consumer extends Thread {
        @Override
        public void run() {
            try {
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("消费者、、、");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            Product product = new Product();
            product.start();
        }
        for (int i = 0; i < 5; i++) {
            Consumer consumer = new Consumer();
            consumer.start();
        }
        for (int i = 0; i < 3; i++) {
            Product product = new Product();
            product.start();
        }
    }
}
