package BIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientSocket {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		Socket client = null;
		BufferedReader reader = null;
		PrintWriter write = null;
		
		try {
			client = new Socket();
			client.connect(new InetSocketAddress("localhost", 8000));
			write = new PrintWriter(client.getOutputStream(), true);
			write.println("hello world");
			write.flush();
			
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			System.out.println("from server = "+reader.readLine()+" "+ Thread.currentThread().getName());
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(write != null) write.close();
			if(reader != null) reader.close();
			if(client != null) client.close();
		}

	}

}
