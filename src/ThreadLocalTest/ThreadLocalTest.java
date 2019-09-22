package ThreadLocalTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest {

	static ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<SimpleDateFormat>();
	public static class ParseData implements Runnable {

		int i = 0;

		public ParseData(int i) {
			this.i = i;
		}

		public void run() {
			try {
				if(tl.get() == null){
				tl.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
			}
				Date date = tl.get().parse("2019-11-1 19:29:"+ i % 60);
				System.out.println(i + ":"+ date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 1000; i++) {
			es.execute(new ParseData(i));
		}
	}

}




