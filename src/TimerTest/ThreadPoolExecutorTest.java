package TimerTest;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class ThreadPoolExecutorTest {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<Runnable>(5)); // ArrayBlockingQueue基于数组的先进先出队列，此队列创建时必须指定大小

		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 15; i++) {
			MyTask myTask = new MyTask(i);
			newCachedThreadPool.execute(myTask);
			System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" + executor.getQueue().size()
					+ "，已执行玩别的任务数目：" + executor.getCompletedTaskCount());
			System.out.println(newCachedThreadPool.isTerminated());
		}
		newCachedThreadPool.shutdown();
	}

}

class MyTask implements Runnable{
	private int taskNum;
    
    public MyTask(int num) {
        this.taskNum = num;
    }
     
    @SuppressWarnings("static-access")
	@Override
    public void run() {
        System.out.println("正在执行task "+taskNum);
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task "+taskNum+"执行完毕");
    }
}
