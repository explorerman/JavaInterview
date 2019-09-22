package TimerTest;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

	private static long start;
	    public static void main(String[] args) throws Exception{
	        TimerTask task1 = new TimerTask(){
	            @Override
	            public void run(){
	                System.out.println("task1 invoked ! " + (System.currentTimeMillis() - start));
	                try{
	                    Thread.sleep(3000);
	                } catch (InterruptedException e){
	                    e.printStackTrace();
	                }

	            }
	        };
	        TimerTask task2 = new TimerTask(){
	            @Override
	            public void run(){
	                System.out.println("task2 invoked ! " + (System.currentTimeMillis() - start));
	            }
	        };
	        Timer Timer = new Timer();
	        start = System.currentTimeMillis();
	        Timer.schedule(task1, 1000);
	        Timer.schedule(task2, 3000);
	    }
}
