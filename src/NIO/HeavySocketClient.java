package NIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

/**
 * 模拟耗时很多的客户端操作
 * @author JIEE_Shine
 *
 */
public class HeavySocketClient {
	
	private static ExecutorService tp = Executors.newCachedThreadPool();
	private static final int sleep_time = 1000*1000*1000;
	public static class EchoClient implements Runnable{

		@Override
		public void run() {
			System.out.printf("当前线程是："+Thread.currentThread().getName());
			Socket client = null;
			BufferedReader reader = null;
			PrintWriter write = null;
			try {
				client = new Socket();
				client.connect(new InetSocketAddress("localhost", 8000));
				write = new PrintWriter(client.getOutputStream(), true);
				write.print("h");
				LockSupport.parkNanos(sleep_time);
				write.print("e");
				LockSupport.parkNanos(sleep_time);
				write.print("l");
				LockSupport.parkNanos(sleep_time);
				write.print("o");
				LockSupport.parkNanos(sleep_time);
				write.print("o");
				LockSupport.parkNanos(sleep_time);
				write.print("w");
				LockSupport.parkNanos(sleep_time);
				write.print("o");
				LockSupport.parkNanos(sleep_time);
				write.print("r");
				LockSupport.parkNanos(sleep_time);
				write.print("d");
				LockSupport.parkNanos(sleep_time);
				write.println();
				write.flush();

				reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
				System.out.println("from server = "+reader.readLine() + " " + Thread.currentThread().getName());
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
				if(write != null) write.close();
				if(reader != null) reader.close();
				if(client != null) client.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
			
		}
		
	}
	public static void main(String[] args) {
		EchoClient ec = new EchoClient();
		for(int i = 0; i < 10; i++){
			tp.execute(ec);
		}
	}

}
