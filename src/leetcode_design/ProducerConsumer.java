package leetcode_design;

import java.util.LinkedList;
import java.util.Queue;

//蚂蚁金服二面算法题： 2.请用java代码实现典型的生成者、消费者场景，要求考虑到多线程并发的情况、缓冲区满的情况
public class ProducerConsumer{

    private Queue<String> queue = new LinkedList<>();
    private final int Max_buffer = 200;
    class Producer extends Thread{
        @Override
        public void run(){
            produce();
        }
        private void produce(){
            while(true){
                synchronized(queue){
                    if(queue.size() == Max_buffer){
                        System.out.println("缓冲区已满");
                        try
                        {
                            queue.wait();
                        }catch (Exception ex){
                            ex.printStackTrace();
                        }
                    }
                    queue.add("producer_task");
                    System.out.println("生产者已经产生一个新任务");
                    queue.notify();
                    try{
                        Thread.sleep(100);
                    }
                    catch(Exception ex){
                        ex.printStackTrace();
                    }

                }

            }

        }
    }

    class Consumer extends Thread{
        @Override
        public void run(){
            consumer();
        }
        private void consumer(){
            while(true){
                synchronized(queue){
                    if(queue.size() == 0){
                        System.out.println("缓冲区为空");
                        try
                        {
                            queue.wait();
                        }catch (Exception ex){
                            ex.printStackTrace();
                        }
                    }
                    queue.poll();
                    queue.notify();
                    System.out.println("消费者已经消费一个任务");
                    try{
                        Thread.sleep(100);
                    }
                    catch(Exception ex){
                        ex.printStackTrace();
                    }
                }

            }

        }
    }
}
