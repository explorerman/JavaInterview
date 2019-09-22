package BIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 传统BIO的socket服务监测单
 * @author JIEE_Shine
 *
 */
public class MultiThreadEchoServer {
	
	private static ExecutorService tp = Executors.newCachedThreadPool();
	
	static class HandleMsg implements Runnable{

		Socket clientSocket;
		
		public HandleMsg(Socket clientSocket) {
			this.clientSocket = clientSocket;
		}
		
		@Override
		public void run() {
			BufferedReader is = null;
			PrintWriter os = null;
			
			try {
				is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				os = new PrintWriter(clientSocket.getOutputStream(), true);
				
				String inputLine = null;
				long b = System.currentTimeMillis();
				while((inputLine = is.readLine()) != null){
					os.print(inputLine+"\n");
					os.flush();
					//或改成如下
//					os.println(inputLine);
				}
				long e = System.currentTimeMillis();
				System.out.println("spend:"+(e - b) + "ms");
				
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					if(is != null) is.close();
					if(os != null) os.close();
					clientSocket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		}
		
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		ServerSocket echoSocket = null;
		Socket clientSocket = null;
		echoSocket = new ServerSocket(8000);
		System.out.println("服务端开始监听~");
		while(true){
			clientSocket = echoSocket.accept();
			System.out.println(clientSocket.getRemoteSocketAddress() + "connect !");
			tp.execute(new HandleMsg(clientSocket));
		}
	}

}
