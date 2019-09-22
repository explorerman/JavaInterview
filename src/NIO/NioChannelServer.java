package NIO;

import java.net.Socket;
import java.nio.channels.Selector;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NioChannelServer {
	 //selector用于处于所有的网络连接
	private Selector selector; 
	//用于对每一个客户端进行相应的处理，每一个请求会委托给线程池中的线程进行实际的处理。
	private static ExecutorService tp = Executors.newCachedThreadPool();
	//用于统计某一个socket上花的时间，key为socket，value为时间戳
	public static Map<Socket, Long> time_stat = new HashMap<Socket, Long>(10240);
	
	private void startServer(){
		
	}
	public static void main(String[] args) {

	}

}
